import os
from flask import Flask, flash, request, redirect, url_for, jsonify
from werkzeug.utils import secure_filename
from backend import process_dataset, sort_questions

lista=[1,2,3]

UPLOAD_FOLDER = './UPLOAD_FOLDER'
ALLOWED_EXTENSIONS = set(['txt', 'pdf', 'png', 'jpg', 'jpeg', 'gif','csv'])

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@app.route('/dataset/upload', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        # check if the post request has the file part
        if 'file' not in request.files:
            flash('No file part')
            return redirect(request.url)
        file = request.files['file']
        # if user does not select file, browser also
        # submit an empty part without filename
        if file.filename == '':
            flash('No selected file')
            return redirect(request.url)
        if file and allowed_file(file.filename):
            filename = secure_filename(file.filename)
            path = os.path.join(app.config['UPLOAD_FOLDER'], filename)
            file.save(path)
            process_dataset(path)
            ret = {'status': 'ok', 'message':'arquivo '+filename+' foi carregado com sucesso!'}
            return jsonify(ret)
    return '''
    <!doctype html>
    <title>Upload new File</title>
    <h1>Upload new File</h1>
    <form method=post enctype=multipart/form-data>
      <input type=file name=file>
      <input type=submit value=Upload>
    </form>
    ''' + str(lista)

@app.route('/dataset/list', methods=['GET'])
def dataset_list():
    files = []
    # r=root, d=directories, f = files
    for r, d, f in os.walk(app.config['UPLOAD_FOLDER']):
        for file in f:
            if '.csv' in file:
                files.append(file)
    return jsonify(files)

@app.route('/questions', methods=['GET'])
def generate_order():
    filename = request.args.get('dataset', default='zombie-health-cases500.csv', type = str)
    path = os.path.join(app.config['UPLOAD_FOLDER'], filename)
    ret = sort_questions(path)
    return jsonify(ret)

@app.route('/examine', methods=['GET'])
def prob_diseases():
    filename = request.args.get('dataset', default='zombie-health-cases500.csv', type = str)
    path = os.path.join(app.config['UPLOAD_FOLDER'], filename)
    

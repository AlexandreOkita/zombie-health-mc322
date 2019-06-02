from flask import Flask, jsonify, request
from urllib.request import urlopen, Request
import os

app = Flask(__name__)
@app.route('/datasets', methods=['GET'])
def teste():
    return "Certo!"

if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    app.run(host='127.0.0.1', port = port)

return jsonify('teste')
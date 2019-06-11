import pandas as pd
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor

def encoder(ds):
    enc = LabelEncoder()
    for i in range(len(ds.columns) -1):
        ds.iloc[:, i] = enc.fit_transform(ds.iloc[:, i])
    return ds

def hot_encoder(ds):
    num_diagnostic = len(ds.columns) -1
    one_hot = pd.get_dummies(ds.iloc[:, num_diagnostic])
    ds = ds.drop(ds.columns[num_diagnostic], axis=1)
    ds = ds.join(one_hot)
    return ds

def process_dataset(dataset):
    ds = pd.read_csv(dataset)
    ds = encoder(ds)
    ds = hot_encoder(ds)
    ds.to_csv(dataset.replace('.csv', '.nsv'))

#return the symps and diseases from dataset
def get_dataset_info(dataset):
    ds = pd.read_csv(dataset)

    symp = []
    for i in ds.columns[:-1]:
        symp.append(i)

    dataset = dataset.replace('.csv', '.nsv')
    ds = pd.read_csv(dataset)
    ds = ds.drop('Unnamed: 0', axis=1)
    diseases = []
    for i in ds.columns:
        if i not in symp:
            diseases.append(i)

    return symp, diseases

def get_greatest_corr(corr):
    max = 0
    for i in range(len(corr)):
        for j in range(len(corr.columns)):
           if corr.iloc[i,j] > max:
                max = corr.iloc[i,j]
                sintoma = j
                doenca = i
    corr.iloc[doenca, sintoma] = 0
    return [sintoma, doenca]

def dictionarize(ask_order):
    keys = ask_order[0]
    return [dict(zip(keys, values)) for values in ask_order[1:]]

def sort_questions(dataset):
    symp, diseases = get_dataset_info(dataset)
    num_symp = len(symp)
    dataset = dataset.replace('.csv', '.nsv')
    ds = pd.read_csv(dataset)
    ds = ds.drop(ds.columns[0], axis=1)
    #we will work with a correlation table to check the best questions to make
    corr = ds.corr()
    #slice the data!
    corr = corr.iloc[len(ds.columns) - num_symp +2:, :num_symp]
    #build a matrix that stores the symp with the disease in best order
    ask_order = []
    for i in range(num_symp):
        array = get_greatest_corr(corr)
        array[0] = symp[array[0]]
        array[1] = diseases[array[1]]
        ask_order.append(array[0]+';'+array[1])
    return ask_order

def get_highest(prob_array):
    i = 0
    n = len(prob_array)
    maiores = [-1, -2] #maior é o -1
    ids = [-1, -1]
    while i < n:
        if prob_array[i][1] > maiores[0]:
            maiores[1] = maiores[0]
            ids[1] = ids[0]
            maiores[0] = prob_array[i][1]
            ids[0] = prob_array[i][0]
        elif prob_array[i][1] > maiores[1]:
            maiores[1] = prob_array[i][1]
            ids[1] = prob_array[i][0]
        i+=1
    return ids


def examine_patient(dataset, patient):
    symp, diseases = get_dataset_info(dataset)
    dataset = dataset.replace('.csv', '.nsv')
    ds = pd.read_csv(dataset)
    models = []
    for i in diseases:
        models.append(generate_models(symp, i, ds))
    ids = get_highest(get_probs(models, patient))
    ids[0] = diseases[ids[0]]
    ids[1] = diseases[ids[1]]
    prob_dis = [ids[0]+';'+ids[1]]
    return prob_dis

#entry: symp array, disease string, dataframe
def generate_models(symp, disease, ds):
    x = ds[symp]
    y = ds[disease]
    x_train, x_test, y_train, y_test = train_test_split(x, y, test_size = 0.1, random_state=0)
    model = RandomForestRegressor()
    model.fit(x_train, y_train)
    return model

def get_probs(models, patient):
    probs = []
    for model in range(len(models)):
        probs.append([model, models[model].predict(patient).tolist()[0]])
    return probs

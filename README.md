# zombie-health-mc322
Repositório utilizado para o trabalho final da disciplina do grupo Dino Scientist de Orientação de Objetos do primeiro semestre de 2019 da Unicamp.

# Documentação dos componentes
Neste README teremos a documentação de todos os componentes presentes neste diretório do projeto. Segue abaixo a documentação de cada um.

## Componente `GraphicComponent`
Campo | Valor
----- | -----
Classe | `project.components.GraphicComponent`
Autores | `Dino Scientists`
Objetivo | `Receber os dados e formar o gráfico das probabilidades`
Interface | `IGraphic`

```
public interface ITableProducerReceptacle {
    public void connect(ITableProducer producer);
}

public interface IGraphic extends IEnquirerReceptacle, ITableProducerReceptacle, IAnswerReceptacle{

}

```


## Componente `DataSet`
Campo | Valor
----- | -----
Classe | `project.components.DataSetComponent`
Autores | `Dino Scientists`
Objetivo | `Organizar as tabelas de entrada em Strings para ser facilmente manipuladas`
Interface | `IDataSet`

```
public interface ITableProducer {
    String[] requestAttributes();
    String[][] requestInstances();
}

public interface IDataSource {
    public String getDataSource();
    public void setDataSource(String dataSource);
}

public interface IDataSet extends IDataSource, ITableProducer {
}
```


## Componente `Patient`
Campo | Valor
----- | -----
Classe | `project.components.Patient`
Autores | `Dino Scientists`
Objetivo | `Implementar métodos para responder perguntas do Doutor`
Interface | `IPatient`

```
public interface ITableProducerReceptacle {
    public void connect(ITableProducer producer);
}

public interface IAnswer {
    public String ask(String question);
    public boolean finalAnswer(String answer);
}

public interface IPatient extends IAnswer, ITableProducerReceptacle {
}
```

## Componente `Doctor`
Campo | Valor
----- | -----
Classe | `project.components.Doctor`
Autores | `Dino Scientists`
Objetivo | `Implementar métodos para fazer as perguntas ao paciente`
Interface | `IDoctor`

```
public void startInterview() {
...
}
public void connect(IAnswer answer) {
...
}
public void connect(ITreeProducer treeProducer) {
...
}
```

## Componente `SecondOpinion`
Campo | Valor
----- | -----
Classe | `project.components.SecondOpinionComponent`
Autores | `Dino Scientists`
Objetivo | `Dar ao paciente uma segunda opinião sobre seus sintomas, verificando a primeira resposta do doutor e comentando caso haja uma segunda doença menos provável mas ainda possível. Abrange os outliers utilizando comparações entre modelos gerados por RandomForest.`
Interface | `ISecondOpinion`

```
public interface IDataSet extends IDataSource, ITableProducer {
}

public interface ISplitDataSet extends IDataSet{
    public String[] getDiseases();
    public String[] getSymptoms();
}


public interface ISecondOpinion extends IDataSet, ISplitDataSet, IPatient {
    public String getHighestProbDisease();
    public String getSecHighestProbDisease();
    
}
```
## Componente `DecisionTree`
Campo | Valor
----- | -----
Classe | `project.components.DecisionTree`
Autores | `Dino Scientists`
Objetivo | `O componente Decision Tree (Primeira Opinião) é responsável por fornecer ao paciente um diagnóstico com base na tabela de correlação. A tabela de correlação mostra o quão relevante é um sintoma para determinado diagnóstico, e assim constrói uma Árvore de Decisão.` 
Interface | `IDecisionTree`

```
public interface ITreeProducer {
    public void buildTree();
}
```

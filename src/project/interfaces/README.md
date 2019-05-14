# Documentação das Interfaces
Neste README teremos as documentações das Interfaces do projeto. Todas estão contidas nesse diretório. Segue abaixo documentação.

### Interface `IDoctor`
Extende outras 4 interfaces: `IEnquirer`, `IAnswerReceptacle`, `ITableProducerReceptacle`, `ITreeProducerReceptacle`. Sendo responsável por aglomerar todas as atividades do Doutor, entre elas: conexão com o paciente para fazer perguntas e com a árvore de decisão para fazer perguntas na ordem ótima obtida.

Método | Objetivo
------ | --------
`connect` | `Responsável pela conexão com o paciente e com a árvore de decisão, de acordo com a assinatura do método (sobrecarga de método)`

### Interface `IAnswerReceptacle`
Faz a conexão entre as componentes **Doctor** e **Patient**. Responsável por passar as perguntas e diagnóstico de **Doctor** a **Patient**.

Método | Objetivo
------ | --------
`connect` | `Recebe uma interface IAnswer da componente Doctor.`

### Interface `IEnquirerReceptable`
Conecta as outras interfaces com o IEnquirer 

Método | Objetivo
------ | --------
`connect` | `Responsável pela conexão das interfaces que extenderem o IEnquireReceptable com o IEnquirer`

### Interface `IGraphic`
Extende outras três interfaces : `IEnquirerReceptacle`, `ITableProducerReceptacle` e `IAnswerReceptacle`. Responsável por unir todas as partes necessárias para a formação do gráfico 

Método | Objetivo
------ | --------
`<no method>` | `<no method>`


### Interface `ITableProducer`
Responsável por pegar as classes e instâncias do DataSet.

Método | Objetivo
------ | --------
`requestAttributes` | `Responsável por captar as classes do DataSet`
`requestInstances` | `Responsável por captar as instâncias de cada classe`

### Interface `IDataSet`
Estende duas outras interfaces: `IDataSource` e `ITableProducer`. Responsável por receber uma tabela de entrada e convertê-la em uma matriz de strings que pode ser facilmente manipulada.

### Interface `ITableProducerReceptacle`
Responsável por conectar a componente **DataSet** provedora de uma tabela .csv de sintomas e doenças à componentes receptoras.

Método | Objetivo
------ | --------
`connect` | Recebe uma interface da componente DataSet que proverá a tabela .csv.

### Interface `ITreeProducer`
Interface responsável por construir a Árvore de Decisão que se encarregará da primeira opinião do Doutor.

Método | Objetivo
------ | --------
`buildTree` | Constrói Árvore de Decisão, selecionando a ordem das melhores perguntas a serem feitas e guarda a referência da árvore internamente.

### Interface `ISplitDataSet`
Extende a interface : `IDataSet`. Interface responsável por separar quais são as doenças e os sintomas no dataset.

Método | Objetivo
------ | --------
`getDiseases` | Retorna um vetor de strings contendo as doenças do dataset.
`getSymptoms` | Retorna um vetor de strings contendo os sintomas do dataset.

### Interface `ISecondOpinion`
Extende outras três interfaces : `IDataSet`, `ISplitDataSet` e `IPatient`. Interface responsável por obter tanto a doença mais provável quanto a segunda mais provável, caso exista.

Método | Objetivo
------ | --------
`getHighestProbDisease` | Retorna uma string contendo a doença mais provável de ocorrer.
`getSecHighestProbDisease` | Retorna uma string contendo a segunda doença mais provável de ocorrer, caso haja a certeza de uma doença apenas, retorna null.

### Interface `IDecisionTree`
Extende outras duas interfaces : `ITreeProducer`, e `ITableProducerReceptacle`. Interface responsável por analisar a tabela de correlações entre doenças e sintomas e fazer a ordem de perguntas mais efetivas.

Método | Objetivo
------ | --------
`getBestQuestions` | Retorna um vetor de contendo a ordem dos sintomas a serem perguntados a fim de diminuir o número de perguntas para descobrir uma doença.

### Interface `ITableProducerReceptacle`
Responsável por conectar a componente **DataSet** provedora de uma tabela .csv de sintomas e doenças à componentes receptoras.

### Interface `ITableReceptacle`
Método | Objetivo
------ | --------
`connect` | Recebe uma interface da componente responsável por produzir a Tabela de Correlação.

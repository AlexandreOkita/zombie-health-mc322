# Documentação das Interfaces
Neste README teremos as documentações das Interfaces do projeto. Todas estão contidas nesse diretório. Segue abaixo documentação.

### Interface `IComponent`
Extendida por todas as interfaces de cada componente, com o intuito de ser uma abstração de um componente para o Abstract Factory pattern

Método | Objetivo
------ | --------
`Sem método` | `Sem método`

### Interface `IComponentFactory`
Fábrica de IComponents;

Método | Objetivo
------ | --------
`createComponent` | `Cria e retorna um componente`

### Interface `IClient`
Responsável por pegar abstrair as operações envolvendo o paciente

Método | Objetivo
------ | --------
`connectDataSet` | `Recebe um DataSet e o armazena`
`setDisease` | `Gera uma doença randomicamente a partir dos dados fornecidos pelo data set`
`getSymp` | `retorna a doença carregada pelo paciente`
`setDisease` | `Gera uma doença randomicamente a partir dos dados fornecidos pelo data set`
`getSintoma` | `Retorna o estado de um sintoma do paciente dado a partir da chave de entrada`
`getName` | `Retorna o hasCode do paciente`

### Interface `IDataSet`
Abstrai DataSets

Método | Objetivo
------ | --------
`requestAttributes` | `Toma uma lista de sintomas de um .csv global`
`setDataSource` | `Carrega o dataset com a global.csv. Em seguida, o dataset faz as manipulações necessárias.`



### Interface `ISecondOpinion`
Extende outras três interfaces : `IDataSet`, `ISplitDataSet` e `IPatient`. Interface responsável por obter tanto a doença mais provável quanto a segunda mais provável, caso exista.

Método | Objetivo
------ | --------
`getHighestProbDisease` | Retorna uma string contendo a doença mais provável de ocorrer.
`getSecHighestProbDisease` | Retorna uma string contendo a segunda doença mais provável de ocorrer, caso haja a certeza de uma doença apenas, retorna null.

### Interface `IFirst`
Abstrai a Primeira Opinião, de modo a facilitar o e legibilizar fluxo de dados dentro do código;

Método | Objetivo
------ | --------
`connect` | `Recebe a áŕvore de perguntas`
`getBestQuestion` | `retorna as melhores perguntas da árvore` 

### Interface `ICRM`
Observer do Pattern Observer. Responsável por processar a repostas do doutor e dar um feedback

Método | Objetivo
------ | --------
`update` | `Atualiza o CRM e devolve o feedback`

### Interface `ISubject`
Observed do Pattern Observer. Responsável por processar a repostas do doutor e dar um feedback. Extendido por ###Doctor

Método | Objetivo
------ | --------
`update` | `Atualiza o CRM e devolve o feedback`

Método | Objetivo
------ | --------
`update` | `Atualiza o CRM e devolve o feedback`

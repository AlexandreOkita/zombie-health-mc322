# Documentação dos componentes
Componentes presentes neste diretório do projeto. Segue abaixo a documentação de cada um:


## Componente `DataSet`
Campo | Valor
----- | -----
Classe | `project.components.DataSetComponent`
Autores | `Dino Scientists`
Objetivo | `Organizar as tabelas de entrada em Strings para ser facilmente manipuladas`
Interface | `IDataSet`

```
public interface IDataSet extends IComponent{
    public String[] requestAttributes();
    public String[][] requestInstances();
    public void setDataSource(String dataSource );
}

```


## Componente `Patient`
Campo | Valor
----- | -----
Classe | `project.components.Patient`
Autores | `Dino Scientists`
Objetivo | `Implementar métodos para responder perguntas do Doutor`
Interface | `IClient`

```
import dinoscientist.interfaces.IComponent;

public interface IClient extends IComponent{
    public void connectDataSet( IDataSet data );
    public void setDisease();
    public List<Integer> getSymp();
    public int getSintoma( String key );
    public String getName();
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

public interface IDoctor extends IComponent{
    public List<SintomaDoenca> getSintoma();
    public List<Integer> getRespostas();
    public String getFOpinion();
    public void connect(IClient patient);
    public List<String> diagnostic(List<SintomaDoenca> questions);
    public void attachCRM(ICRM council);
    public void dettachCRM();
}

```

## Componente `CRM`
Campo | Valor
----- | -----
Classe | `project.components.SecondOpinionComponent`
Autores | `Dino Scientists`
Objetivo | `Dar ao paciente uma segunda opinião sobre seus sintomas, verificando a primeira resposta do doutor e comentando caso haja uma segunda doença menos provável mas ainda possível. Abrange os outliers utilizando comparações entre modelos gerados por RandomForest.`
Interface | `ICRM`

```
public interface ICRM extends IObserver, IComponent{
    public List<String> update( List<Integer> respostas ) throws Exception;
}

```
## Componente `FirstOpinion`
Campo | Valor
----- | -----
Classe | `project.components.DecisionTree`
Autores | `Dino Scientists`
Objetivo | `O componente Decision Tree (Primeira Opinião) é responsável por fornecer ao paciente um diagnóstico com base na tabela de correlação. A tabela de correlação mostra o quão relevante é um sintoma para determinado diagnóstico, e assim constrói uma Árvore de Decisão.` 
Interface | `IFirst`

```
public interface IFirst extends IComponent{
    public void connect(IQuestions question);
    public List<SintomaDoenca> getBestQuestion( String dataset ) throws Exception;
}
```

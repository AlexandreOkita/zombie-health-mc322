## Componente `PrimeiraOpiniao`
Campo | Valor
----- | -----
Classe | `br.unicamp.mc322.zumbidocapi.Questoes`
Autores | `Dino Scientists`
Objetivo | `O componente PrimeiraOpiniao (Question) é responsável por fornecer ao doutor uma lista de perguntas na ordem de prioridade com base na tabela de correlaçãob(a tabela de correlação mostra o quão relevante é um sintoma para determinado diagnóstico). Caso o paciente tenha um dos sintomas apontados pela lista, ele possui a doença que está atrelada ao sintoma.

```
public interface Question {
    public List<SintomaDoenca> list(String dataset)();
}

Exemplo:

Questoes quest = new Questoes();
String dataset = "zombie-health-new-cases500.csv";
List<SintomaDoenca> lista = quest.list(dataset);
for (SintomaDoenca sd : lista) {
    System.out.println(sd.getSintoma()+", "+sd.getDoenca());
}

//saída:  Olho vermelho, Gripe Aviaria
          Dor no Peito, Infecção Viral
          Dedo Tremendo, Zulombriga
          Língua Amarela, Infecção Bacteriana
          Raiva Severa, Briga
          Paralisia, Infecção Bacteriana
          Raiva Severa, T-Virus
          Pele azul, T-Virus 
```


## Classe `SintomaDoenca`
Campo | Valor
----- | -----
Autores | `Dino Scientists`
Objetivo | `A classe tem como função apenas armazenar um par de sintoma com uma doenca para o uso no componente PrimeiraOpiniao.`
Métodos | `public String getSintoma()`
	  `public String getDoenca()`
	  `public String setSintoma()`
	  `public String setDoenca()`
Atributos | `private String sintoma`
	    `private String doenca`
	     
## Componente `CRM (Centro Regional de Médicos)`
Campo | Valor
----- | -----
Classe | `br.unicamp.mc322.zumbidocapi.Examine`
Autores | `Dino Scientists`
Objetivo | `O componente CRM (Examine) irá simular uma análise mais detalhada sobre o paciente para tentar sugerir a existência de doenças 'outliers'. Ele funciona dando o vetor completo de sintomas para o CRM que é analisado por um RandomForestRegressor do scikit-learn que roda em um servidor Ubuntu AWS.`


```
public interface Examine {
    public List<String> execute(String dataset, List<Integer> respostas);
}

Exemplo:

Examine examine = new Examine();
List<String> outrasOpcoes =examine.execute(dataset, xx);
int i = 1;
for (String opc : outrasOpcoes) {
	System.out.println("Doenca "+i+":"+opc);
	i++;
}

//saída:  Doenca 1:Infecção Bacteriana
	  Doenca 2:Briga
```

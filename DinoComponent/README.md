## Componente `DecisionTree`
Campo | Valor
----- | -----
Classe | `br.unicamp.mc322.zumbidocapi.Questoes`
Autores | `Dino Scientists`
Objetivo | `O componente Decision Tree (Primeira Opinião) é responsável por fornecer ao doutor uma lista de perguntas na ordem de prioridade com base na tabela de correlação
(a tabela de correlação mostra o quão relevante é um sintoma para determinado diagnóstico).
Caso o paciente tenha um dos sintomas apontados pela lista, ele possui a doença que está atrelada ao sintoma.

```
public interface Question {
    public List<SintomaDoenca> list(String dataset)();
}

Exemplo:

Questoes quest = new Questoes();
String dataset = "zombie-health-new-cases500.csv";
List<SintomaDoenca> lista = quest.list(dataset);
for (SintomaDoenca sd : ret) {
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

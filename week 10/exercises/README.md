<!-- Header -->
<header> 
  <h1><b>RDF</b></h1>
</header>

<!-- Content -->
## Цели на упражнението:
		
```
1. Използване на основни конструкции на Resource Description Framework (RDF) в примери и валидирането им
2. Създаване на авторски RDF документи
3. Използване на основни конструкции на RDF Schema (RDFS) в примери и валидирането им
4. Създаване на авторски RDFS документи
```

<br/>

<h4>Задача 1: Разгледайте следния RDF документ:</h4>
    
```rdf
<?xml version="1.0"?> 
<rdf:RDF 
xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" 
xmlns:bc="https://learn.fmi.uni-sofia.bg/"> 
   <rdf:Description rdf:about="https://learn.fmi.uni-sofia.bg/course/view.php?id=3660"> 
      <bc:title>XML technologies for Semantic Web, winter semester 2017/2018</bc:title> 
      <bc:author>Prof. Boyan Bontchev</bc:author> 
   </rdf:Description> 
</rdf:RDF>
```

   Валидирайте го онлайн на адрес https://www.w3.org/RDF/Validator/, като изберете Display Result опциите „Triples and Graph“ и „PNG - embedded“.
   Трябва да получите следния резултат:

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task1.png"/>

<h4>Задача 2: За съдържанието от дадената таблица по-долу, създайте RDF документ, като използвате елементите &lt;cd:artist&gt;, &lt;cd:country&gt;, &lt;cd:company&gt; и т.н. като свойства на ресурса.</h4>

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task2Table.png"/>

Валидирайте го онлайн на адрес https://www.w3.org/RDF/Validator/, като трябва да получите следния резултат:

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task2.png"/>

<h4>Задача 3:  За създадения от задача 2 RDF документ, заменете елементите &lt;cd:artist&gt;, &lt;cd:country&gt;, &lt;cd:company&gt; и т.н. с атрибути като свойства на ресурса. Валидирайте новосъздадения документ на адрес https://www.w3.org/RDF/Validator/.</h4>



<h4>Задача 4: Преработете създадения от задача 2 RDF документ, като:</h4>

1. Замените литералната стойност за елементите &lt;cd:artist&gt; с референция към ресурс, например &lt;cd:artist rdf:resource=" http://www.myshop.bg/cd/joecocker" /&gt;.
2. Опишете новия ресурс в отделен rdf:Description елемент, като използвате елементите &lt;cd:name&gt;, &lt;cd:country&gt;, &lt;cd:born&gt;, &lt;cd:style&gt; и &lt;cd:homepage&gt;.
3. Валидирайте новосъздадения документ на адрес https://www.w3.org/RDF/Validator/, като трябва да получите следния резултат:

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task4.png"/>

<h4>Задача 5: Създайте и валидирайте на адрес https://www.w3.org/RDF/Validator/ примерни RDF документи с контейнери, описващите групи от тип &lt;Bag&gt;, &lt;Seq&gt; и &lt;Alt&gt;. 
След валидирането, разгледайте и обяснете получените графи, които трябва да включват конструкции като тези по-долу:</h4>

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task5_1.png"/>
<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task5_2.png"/>
<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task5_3.png"/>

<h4>Задача 6: Създайте и валидирайте на адрес https://www.w3.org/RDF/Validator/ примерен RDF документ с колекция (с използването на атрибута rdf:parseType="Collection"). 
След валидирането, разгледайте и обяснете получения граф.</h4>

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task6.png"/>

<h4>Задача 7: Създайте XML документ за следния граф:</h4>

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%2010/exercises/images/task7.png"/>


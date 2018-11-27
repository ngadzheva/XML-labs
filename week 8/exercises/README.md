<!-- Header -->
<header> 
  <h1><b>XSLT</b></h1>
</header>

<!-- Content -->
## Цели на упражнението:
		
```
1. Използване на основни функции на XSLT
```

<br/>

<h4>Задача 1: За дадения по-долу XML документ създайте XSL документ, който чрез <xsl:if>, извежда в HTML формат:</h4>

<pre>
1. Стойностите на всички <b><i>track</i></b> елементи, които имат стойност на атрибута <b><i>length '4:04'</i></b>
2. Стойностите на всички <b><i>track</i></b> елементи, чиято дължина е по-малка от 15, както и техните дължини
3. Всички <b><i>track</i></b> елементи на четни/нечетни позиции
</pre>

XML документ:
    
```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<?xml-stylesheet type="text/xsl" href="catalogDisplay.xsl"?>
<catalog>
   <cd category="Techno" id="8c0a600b">
      <artist>TATU</artist>
      <title>200 po vstrechnoy</title>
      <year>2002</year>
      <tracklist num="1">
         <track length="4:10">Zachem ya? (Tell Me Why)</track>
         <track length="3:34">Ya soshla s uma (Mad as Hell)</track>
         <track length="4:40">Nas ne dogonyat (On The Run)</track>
         <track length="4:39">Doschitay do sta (Countdown)</track>
         <track length="3:21">30 minut (Another Minute)</track>
         <track length="4:19">Ya tvoy vrag (Wake Up, Time To Die)</track>
         <track length="4:20">Ya tvoya ne pervaya (First In First Out)</track>
         <track length="3:55">Robot (Robotronik)</track>
         <track length="3:20">Malchik-gay (Zoophilic Lolita)</track>
         <track length="3:53">Nas ne dogonyat (HarDrum rmx)</track>
         <track length="4:04">30 minut (HarDrum rmx)</track>
      </tracklist>
   </cd>
   <cd category="Techno" id="cd100010">
      <artist>Tatu</artist>
      <title>Zvezdnaya seriya 2001</title>
      <year>2001</year>
      <tracklist num="2">
         <track length="3:31">Ya soshla s uma</track>
         <track length="3:53">Robot</track>
         <track length="4:08">Zachem ya?</track>
         <track length="4:36">Doschitaj do sta</track>
         <track length="4:17">Ya tvoj vrag</track>
         <track length="4:38">Nas ne dogonyat</track>
         <track length="3:18">Mal'chik-gej</track>
         <track length="3:18">30 minut</track>
         <track length="4:18">Ya ne tvoya pervaya</track>
         <track length="3:50">Nas ne dogonyat (hardrum remix)</track>
         <track length="4:03">30 minut (hardrum remix)</track>
         <track length="4:03">Ya soshla s uma (dj ram remix)</track>
         <track length="4:10">Ya soshla s uma (hardrum remix)</track>
         <track length="3:37">Ya soshla s uma (dj ram breakbeat remix)</track>
         <track length="7:00">Ya soshla s uma (S.Galoyan remix)</track>
         <track length="5:36">Ya soshla s uma (Video)</track>
      </tracklist>
   </cd>
</catalog>
```


<h4>Задача 2: За дадения в <i>задача 1</i> XML документ, създайте XSL документ, който чрез <xsl:choose> за всеки елемент <b><i>track</i></b>, извежда в HTML формат:</h4>

<pre>
1. "A big string", ако дължината на стойността на <b><i>track</i></b> елемента е по-голяма от 15
2. "A small string", ако дължината на стойността на <b><i>track</i></b> елемента е по-малка от 15
3. "A medium string", ако дължината на стойността на <b><i>track</i></b> не отговаря на нито едно от горните условия
</pre>
 
<h4>Задача 3: За XML документа от <i>задача 1</i>създайте XSL документ, който чрез <xsl:sort> сортира стойностите на <i>track</i> елементите</h4>
<pre>
1. В нарастващ ред
2. В намаляващ ред
3. В нарастващ или намаляващ ред в следния формат: <b><i>track_1, track_2,...,track_n</i></b>
</pre>

<h4>Задача 4: За XSL документа от <i>задача 3</i> дефинирайте константа, като използвате <xsl:variable> и изведете стойността ѝ</h4>
  
<h4>Задача 5: За XSL документа от <i>задача 3</i> дефинирайте параметър, като използвате <xsl:param> и изведете стойността му</h4>

<h4>Задача 6: За XSL документа <i>задача 3</i> като използвате <xsl:call-template>, дефинирайте и извикайте следните шаблони:</h4>

<pre>
1. Шаблон с име <b><i>year</i></b>, който извежда стойността на <b><i>year</i></b> елемента
2. Шаблон с име <b><i>title</i></b>, който извежда стойността на <b><i>title</i></b> елемента
3. Шаблон с име <b><i>artist</i></b>, който извежда стойността на <b><i>artist</i></b> елемента
</pre>

<h4>Задача 7: За XSL документа <i>задача 3</i> като използвате <xsl:call-template> и <xsl:with-param>, дефинирайте и извикайте следните шаблони с параметри:</h4>

<pre>
1. Шаблон с име <b><i>year</i></b>, който има параматър с име <b><i>yearName</i></b> и извежда стойността на <b><i>year</i></b> елемента
2. Шаблон с име <b><i>title</i></b>, който има параматър с име <b><i>titleName</i></b> и извежда стойността на <b><i>title</i></b> елемента
3. Шаблон с име <b><i>artist</i></b>, който има параматър с име <b><i>artistName</i></b> и извежда стойността на <b><i>artist</i></b> елемента
</pre>

<h4>Задача 8: За XML документа <i>задача 1</i> като използвате <xsl:copy-of>, съставете XSL документ, който връща в XML формат следните 2 под-елемента на елемента cd:</h4>

<pre>
1. Стойността на под-елемента <b><i>title</i></b>
2. Под-елемента <b><i>tracklist</i></b> заедно с цялата негова структура
</pre>

<h4>Задача 9: Решете <i>задача 8</i>, като използвате <xsl:element> и <xsl:attribute> вместо <xsl:copy-of></h4>

<h4>Задача 10: За XML документа <i>задача 1</i> като използвате <xsl:apply-templates>, създайте XSL документ, който съдържа неименовани шаблони, селектиращи стойностите на следните елементи и техните атрибути (ако са дефинирани):</h4>

<pre>
1. <b><i>title</i></b>
2. <b><i>year</i></b>
3.<b><i>track</i></b>
</pre>

<h4>Задача 11: Решете <i>задача 10</i>, като използвате <xsl:apply-templates> заедно с атрибута <i>mode</i> и по този начин резултатният XSL документ съдържа неименовани шаблони, селектиращи следните стойности:</h4>

<pre>
1. Стойността на елемента <b><i>title</i></b>
2. Стойността на елемента <b><i>year</i></b>
3. Стойностите на елемента <b><i>track</i></b> без неговите атрибути (при <b><i>mode="withoutAttributes"</i></b>)
4. Стойностите на елемента <b><i>track</i></b> заедно с неговите атрибути (при <b><i>mode="withAttributes"</i></b>)
</pre>
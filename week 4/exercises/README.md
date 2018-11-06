<!-- Header -->
<header> 
  <h1><b>XPATH и XQUERY</b></h1>
</header>

<!-- Content -->
## Цели на упражнението:
		
```
1. Използване на основни функции на XPATH
2. Използване на основни функции на XQUERY

```

<br/>

<h4>Задача 1: Създайте следните XSL и XML документи и разгледайте XML документа с Internet Explorer или Mozilla Firefox. 
Може да включите XPATH изразите от <i>задачи 2 и 3</i> в дадения по-долу XSL документ по подобен начин</h4>
    
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

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:template match="/">
      <html>
         <body>
            <h2>My CD Collection</h2>
            <table border="1">
               <tr bgcolor="#9acd32">
                  <th align="left">Title</th>
                  <th align="left">Artist</th>
                  <th align="left">Year</th>
                  <th align="left">Category</th>
                  <th align="left">ID</th> 
               </tr>
               <xsl:for-each select="catalog/cd">
               <tr>
                  <td><xsl:value-of select="title"/></td>
                  <td><xsl:value-of select="artist"/></td>
                  <td><xsl:value-of select="year"/></td> 
                  <td><xsl:value-of select="./@category"/></td> 
                  <td><xsl:value-of select="./@id"/></td> 
               </tr>
               <tr>
                  <td>
                     <xsl:for-each select="tracklist/track">
                        <li><xsl:value-of select="text()"/></li>
                     </xsl:for-each>
                  </td>
               </tr>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
```

<h4>Задача 2: За XML документа от <i>задача 1</i> напишете XPATH изрази, които извеждат:</h4>

<pre>
  <ul>
    <li>Стойностите на всички <b><i>track</i></b> елементи, чийто атрибут <b><i>length</i></b> е равен на <b><i>'4:04'</i></b> и са включени в елемент <b><i>cd</i></b>, имащ <b><i>id</i></b>, равно на <b><i>8c0a600b</i></b></li>
  	<li>Всички <b><i>track</i></b> елементи на четни/нечетни позиции</li>
    <li>Стойностите на всички <b><i>track</i></b> елементи, чиято дължина на текста е по-голяма от <i>35</i></li>
    <li>Дължината на текста на всички <b><i>track</i></b> елементи, чиято дължина на текста е по-голяма от <i>15</i></li>
    <li>Последния <b><i>track</i></b> елемент от всяко <b><i>cd</i></b></li>
    <li>Петия <b><i>track</i></b> елемент от всяко <b><i>cd</i></b></li>
		<li>Броя на <b><i>track</i></b> елементите за всяко <b><i>cd</i></b></li>
		<li>Всички <b><i>track</i></b> елементи, които съдържат <i>'Ya soshla s uma'</i></li>
		<li>Всички <b><i>track</i></b> елементи, които започват с буквата <i>'D'</i></li>
		<li>Всички <b><i>track</i></b> елементи, които завършват с израза <i>'sta'</i></li>
		<li>Стойностите на всички <b><i>track</i></b> елементи, разпечатани с главни букви</li>
		<li>Стойността на елемента <b><i>year</i></b>, който е под-елемент на елемента <b><i>cd</i></b>, съдържащ под-под-елемент <b><i>track</i></b> с <b><i>length = '3:55'</i></b> и имащ стойност <i>'Robot (Robotronik)'</i></li>
		<li>Среден брой <b><i>track</i></b> елементи от всички налични <b><i>cd</i></b> елементи</li>
		<li>За всеки елемент <b><i>cd</i></b> изведете стойността на под-елементите му <b><i>title</i></b> и <b><i>year</i></b>, спазвайки следния модел: 
				<i>Заглавие: title_value; Година на издаване: year_value</i></li>
  </ul>
</pre>
 
<h4>Задача 3: За XML документа от <i>задача 1</i>, като използвате оси (axes), съставете XPATH израз, който извежда:</h4>
<pre>
  <ul>
    <li>За елемента:
				1. <b><i>tracklist</i></b>
				2. <b><i>year</i></b>
			негова стойност или стойност на негов атрибут</li>
  	<li>Атрибутите <b><i>num</i></b> и <b><i>id</i></b> съответно на елементите <b><i>tracklist</i></b> и <b><i>cd</i></b></li>
    <li>Всички елементи <b><i>track</i></b>, които се намират преди <b><i>track</i></b> елемента със стойност <i>'Doschitay do sta (Countdown)'</i></li>
    <li>Всички елементи <b><i>track</i></b>, които се намират след <b><i>track</i></b> елемента със стойност <i>'Doschitay do sta (Countdown)'</i></li>
		<li>Всички стойности на под-елементите на всички елементи <b><i>cd</i></b> в документа</li>
		<li>Стойностите на всички елементи, които имат атрибут с име <b><i>id</i></b></li>
		<li>Стойностите на всички елементи, които имат какъвто и да било атрибут</li>
		<li>Атрибута <b><i>num</i></b> с максимална стойност</li>
  </ul>
</pre>

<h4>Задача 4: За XML документа от <i>задача 1</i>, съставете XQUERY израз:</h4>
<pre>
  <ul>
    <li> Селектиращ всички стойности на елемента <b><i>track</i></b>, който е под-елемент на <b><i>tracklist</i></b>, имащ атрибут <b><i>num</i></b>, равен на <i>1</i>. 
   					А. Подредете резултата от 1. по азбучен ред 
   					Б. Подредете резултата от 1. в обратен азбучен ред</li>
  	<li>Създаващ следната структура:
					<records>
						<record cd_ID="CD_ID_VALUE" artist="ARTIST_VALUE">
									<info>Title: TITLE_VАLUE, Year: YEAR_VALUE, Track numbers: COUNT_OF_TRACKS</info>
						</record>
					<records>
			в която стойностите на <b><i>CD_ID_VALUE</i></b>, <b><i>ARTIST_VALUE</i></b>, <b><i>TITLE_VАLUE</i></b>, <b><i>YEAR_VALUE</i></b>, <b><i>COUNT_OF_TRACKS</i></b> отговарят съответно на стойностите 
			на атрибута <b><i>id</i></b> на елемента <b><i>cd</i></b>, на елемента <b><i>artist</i></b>, на елемента <b><i>title</i></b>, на елемента <b><i>year</i></b>, на броя на елементите <b><i>track</i></b> за съответния елемент <b><i>cd</i></b></li>
    <li>Създаващ списък със стойността на всички <b><i>track</i></b> елементи от всички <b><i>cd</i></b> елементи, следващ модела:
					<tracks>
						<track> TRACK_NAME_1</track>
						<track> TRACK_NAME_2</track>
						<track> .........................................</track>
						<track> TRACK_NAME_N</track>
					<tracks></li>
  </ul>
</pre>


  
<h4>Задача 5:  Решете <i>задача 4</i> като дефинирате една XQUERY функция и след това я използвате</h4>


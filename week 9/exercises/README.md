<!-- Header -->
<header> 
  <h1><b>CSS</b></h1>
</header>

<!-- Content -->
## Цели на упражнението:
		
```
1. Дефиниране на вграден (Inlining) CSS стил
2. Асоцииране на CSS дефиниция на стилове (вътрешна и външна) в XML и HTML документ
3. Дефиниране на CSS стилове върху различни медии (напр. принтер, екран, т.н.)
4. Използване на няколко CSS дефиниции за един XML/HTML документ
5. Вмъкване на CSS дефиниция в друга CSS дефиниция
6. Използване на CSS селектори - прости селектори, контекстови селектори, селектори и класове, различни типове 
   селектори - пряк наследник, "брат/сестра", за атрибути и т.н.
7. Асоцииране на даден CSS стил с част/и от XML/HTML документ, чрез използване на ID, CLASS, STYLE
8. Групиране на CSS дефиниции
9. Каскаден ред
10. Кутиен модел - блокови (block) и поредови (inline) кутии
11. Позициониране
```

<br/>

<h4>Задача 1: За дадената по-долу CSS дефиниция създайте XML и HTML документ, върху които тя се прилага като вътрешна (само за HTML документа) и външна. След това разделете външната дефиниция на три части в три отделни CSS документа и изпълнете следните задачи:</h4>

<pre>
1. Включете трите дефиниции към вече създадения XML/HTML документ.
2. Импортирайте две от дефинициите в третата и я приложете (третата дефиниция с импортираните други две) към вече 
   създадения XML/HTML документ.
3. Променете по различен начин един и същ стил в третата дефиниция и в импортираните дефиниции, за да видите коя 
   промяна остава в сила.
</pre>

CSS документ:
    
```css
p { 
   color:#000066; 
   background-color:white; 
   text-indent:.5in; 
   line-height:1.5 
} 

p a { 
   font-size:30px; 
   color:black; 
   background-color:#FFFFCC; 
} 

.quote { 
   color:#000066; 
   background-color:white; 
   font-size:11pt; 
   font-style:italic; 
   line-height:normal 
} 

h1 { 
   color:#000066; 
   background-color:white; 
   margin-left:100px; 
   text-align:center; 
   text-transform:uppercase 
} 

h2, h3 { 
   color:#000066; 
   background-color:white; 
   margin-left:100px; 
   text-align:left; 
   font-style:italic 
} 

h4 { 
   color:#000066; 
   background-color:#d7d7d7; 
   font-size:12pt; 
   font-weight:bold; 
   font-style:normal 
} 

ul li { 
   color:#660000; 
   background-color:white; 
   list-style-type:disc; 
} 

ul li li { 
   color:#660000; 
   background-color:white; 
   list-style-type:circle 
} 

ol li { 
   color:#660000; 
   background-color:white; 
   list-style-type:upper-roman 
} 

ol li li { 
   color:#660000; 
   background-color:white; 
   list-style-type:lower-alpha 
} 

a:link { 
   color:blue; 
   background-color:white; 
   text-decoration:none 
} 

a:active { 
   color:blue; 
   background-color:red; 
   text-decoration:none 
} 

a:visited { 
   color:blue; 
   background-color:white; 
   text-decoration:none 
} 

a:hover { 
   color:purple; 
   background-color:yellow; 
   text-decoration:underline 
}
```

<b><i>Упътване</i></b>

```xml
<?xml version="1.0" encoding="UTF-8"?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
   <head> 
      <title>Task1</title> 
      <!-- internal CSS definition --> 
      <style> 
<!-- тук запишете вътрешната CSS дефиниция --> 
      </style> 
      <!-- external CSS definition --> 
      <link rel="stylesheet" href="task1.css" type="text/css"/> 
   </head> 
   <body> 
      <h1>Header 1</h1> 
      <h2>Header 2</h2> 
      <h3>Header 3</h3> 
      <h4>Header 4</h4> 
      <table> 
         <tr> 
            <td> 
               <a href="#Link2" id="Link">Link</a> 
            </td> 
         </tr> 
         <tr> 
            <td> 
               <ul title="Unordered"> 
               <li>1</li> 
               <li>2 
               <ol> 
               <li>2.1</li> 
               <li>2.2</li> 
               </ol> 
               </li> 
               </ul> 
            </td> 
            </tr> 
            <tr> 
            <td> 
               <ol title="Ordered"> 
               <li>1</li> 
               <li>2 
               <ol> 
               <li>2.1</li> 
               <li>2.2</li> 
               </ol> 
               </li> 
               </ol> 
            </td> 
         </tr> 
         <tr> 
            <td> 
               <p> 
                  <a href="#Link" id="Link2">Link 2</a> 
               </p> 
            </td> 
         </tr> 
      </table> 
   </body> 
</html> 
```

```css
За импортиране на дефинициите от документ task1_2_1.css използвайте 
@import url('task1_2_1.css');
```

<h4>Задача 2: В дадения по-долу HTML документ, отделете информацията относно форматирането (fonts, colors, alignment,...) в отделен CSS документ и го приложете, за да получите същия изглед с вече редуциран код</h4>

```html
<html> 
   <head> 
      <meta http-equiv="Content-Language" content="en-us"> 
      <meta name="GENERATOR" content="Microsoft FrontPage 5.0"> 
      <meta name="ProgId" content="FrontPage.Editor.Document"> 
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"> 

      <title>Section 1</title> 
   </head> 

   <body bgcolor="#FFFF00" link="#00FF00"> 
      <p><font color="#008080" size="5" face="Arial"><b>Section 1</b></font></p> 

      <table border="3" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" 
	     width="50%" id="AutoNumber1"> 
         <tr> 
            <td width="50%" bgcolor="#00FF00" bordercolor="#FF0000" align="center">
               <b>Column 1 title</b>
            </td> 
            <td width="50%" bgcolor="#00FF00" bordercolor="#FF0000" align="center">
               <b>Column 2 title</b>
            </td> 
         </tr> 
         <tr> 
            <td width="50%" bgcolor="#00FF00" bordercolor="#FF0000">Value 1</td> 
            <td width="50%" bgcolor="#00FF00" bordercolor="#FF0000" align="right">0.79</td> 
         </tr> 
         <tr> 
            <td width="50%" bgcolor="#00FF00" bordercolor="#FF0000">Value 2</td> 
            <td width="50%" bgcolor="#00FF00" bordercolor="#FF0000" align="right">10.80</td> 
         </tr> 
      </table> 

      <p>&nbsp;</p> 
      <p>
         <font color="#008080" size="5" face="Arial"><b>Section </b></font>
         <b><font face="Arial" size="5" color="#008080">2</font></b>
      </p> 

      <table border="3" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" 
	     width="50%" id="AutoNumber1"> 
         <tr> 
            <td width="50%" bgcolor="#00FFFF" bordercolor="#FF0000" align="center">
               <b>Column 1 title</b>
            </td> 
            <td width="50%" bgcolor="#00FFFF" bordercolor="#FF0000" align="center">
               <b>Column 2 title</b>
            </td> 
         </tr> 
         <tr> 
            <td width="50%" bgcolor="#00FFFF" bordercolor="#FF0000">Value 1</td> 
            <td width="50%" bgcolor="#00FFFF" bordercolor="#FF0000" align="right">0.79</td> 
         </tr> 
         <tr> 
            <td width="50%" bgcolor="#00FFFF" bordercolor="#FF0000">Value 2</td> 
            <td width="50%" bgcolor="#00FFFF" bordercolor="#FF0000" align="right">10.80</td> 
         </tr> 
      </table> 

      <p>
         <font color="#008080" size="5" face="Arial"><b>Section </b></font>
         <b><font face="Arial" size="5" color="#008080">3</font></b>
      </p> 

      <blockquote> 
         <p><font face="Arial" color="#996600">Normal paragraph text.</font></p> 
         <p><font face="Arial" color="#996600">Normal paragraph text.</font></p> 
         <p><font face="Arial" color="#996600">Normal paragraph text.</font></p> 
         <p><font face="Arial" color="#996600"><a href="http://www.dir.bg">link</a></font></p> 
      </blockquote> 
   </body> 
</html>
```

<b><i>Упътване</i></b>

```css
Дефинирайте стилове с два класа за таблици, напр. 

table.green{ 
    border: 3px solid #111111; 
    padding: 0px; 
    border-spacing: 0px; 
    border-collapse: collapse; 
    width: 50%; 
    background-color: #00ff00; 
} 

и 

table.blue{ 
   	padding: 0px; 
    border-spacing: 0px; 
    border-collapse: collapse; 
    width: 50%; 
    border: 3px solid #111111; 
    background-color: #00ffff; 
} 
```

<h4>Задача 3: За дадения по-долу XML документ, създайте следните варианти на CSS дефиниция:</h4>

<pre>
1. CSS дефиниция, която форматира по различен начин под-елементите на <i><b>item</b></i> - <i><b>title</b></i>, <i><b>description</b></i> и <i><b>link</b></i>
 и по един и същи начин под-елементите на <i><b>textinput</b></i> - <i><b>title</b></i>, <i><b>description</b></i>, <i><b>name</b></i> и <i><b>link</b></i>
2. CSS дефиниция, която форматира по различен начин под-елементите на <i><b>item</b></i> - <i><b>title</b></i>, <i><b>description</b></i> и <i><b>link</b></i>, 
 в зависимост от изхода на клиента (принтер или екран) и в зависимост от размера на екрана на клиента
</pre>

```xml
<?xml version="1.0" encoding="UTF-8"?> 
<rss version="0.91"> 
   <channel location="remote" company="N.A."> 
       <title>Linux Today</title> 
       <link>http://linuxtoday.com</link> 
       <language>en-us</language> 
       <description>Linux Today News Service</description> 
       <image author="anonymous"> 
           <title>Linux Today</title> 
           <url>http://linuxtoday.com/pics/ltnet.png</url> 
           <link>http://linuxtoday.com</link> 
       </image> 
       <item> 
           <title>CNET News.com: USB 2 arrives in Linux test version</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-008-20-NW-KN-DV 
           </link> 
           <description> 
               "The USB support in the world of Linux is much more freewheeling than at 
               Microsoft. The Linux USB software has been created by a largely 
               self-appointed team of programmers, who feed batches of code to the 
               main kernel project." 
           </description> 
       </item> 
       <item> 
           <title> 
               The Register: Open source developers face new warranty threat 
           </title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-007-20-NW-LL 
           </link> 
           <description> 
               "If there's one thing free software developers hate more than writing 
               documentation, it's fighting a long-drawn out and unglamorous legal 
               battle. But the latest episode in the UCITA saga bodes ill for any 
               free software author based in the United States." 
           </description> 
       </item> 
       <item> 
           <title>Mandrake Linux Security Update Advisory: sudo</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-012-20-SC-MD 
           </link> 
           <description> 
               "The SuSE Security Team discovered a vulnerability in sudo that can be 
               exploited to obtain root privilege because sudo is installed setuid 
               root. An attacker could trick sudo to log failed sudo calls 
               executing the sendmail (or equivalent mailer) program with root 
               privileges and an environment that is not completely clean." 
           </description> 
       </item> 
       <item> 
           <title>NewsForge: An Open Source adventure at MacWorld</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-006-20-PS-BD 
           </link> 
           <description> 
               "'For me, what Darwin brings is not so much another alternative to Linux 
               or FreeBSD or whatever, as those systems I have that are running 
               some Open Source BSD are likely to continue doing that. It's the 
               fact that there is an Open Source kernel and utility suite and 
               libraries that will support proprietary commercial applications that 
               I'm willing to pay for but can't run on most of my other systems.'" 
           </description> 
       </item> 
       <item> 
           <title> 
               Linux Journal: Sysadmin Corner: Unsung Heroes, Part 2 
           </title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-005-20-RV-SW 
           </link> 
           <description> 
               "It seems that several people decided I should show off their web photo 
               album generation tool of choice. So, in response to your 
               suggestions, I'm going to put off the cool network tool for today; 
               let's go on the premise that you all took thousands of pictures over 
               the holidays and are dying to make them available on the Web." 
           </description> 
       </item> 
       <item> 
           <title>Conectiva Linux Security Announcement: sudo</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-004-20-SC 
           </link> 
           <description> 
               "Sebastian Krahmer from SuSe found a vulnerability in the sudo package which 
               could be used by a local attacker to obtain root privileges. 
               Versions prior to and including 1.6.3p7 remove a few potentially 
               dangerous environment variables prior to executing a command as 
               root, but other variables could be abused and used to obtain root 
               privileges." 
           </description> 
       </item> 
       <item> 
           <title>IBM developerWorks: Introducing XFS</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-003-20-PS-KN 
           </link> 
           <description> 
               "Up until now, choosing the appropriate next-generation Linux 
               filesystem has been refreshingly straightforward. Those who were 
               looking for raw performance generally leaned towards ReiserFS, while 
               those more interested in meticulous data integrity features 
               preferred ext3. However, with the release of XFS for Linux, things 
               have suddenly become much more confusing. In particular, it's no 
               longer clear that ReiserFS is still the next-gen performance 
               leader." 
           </description> 
       </item> 
       <item> 
           <title>Red Hat Security Advisory: sudo</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-002-20-SC-RH 
           </link> 
           <description> 
               "Versions of sudo prior to 1.6.4 would not clear the environment before 
               sending an email notification about unauthorized sudo attempts, 
               making it possible for an attacker to supply parameters to the mail 
               program. In the worst case, this could lead to a local root 
               exploit." 
           </description> 
       </item> 
       <item> 
           <title> 
               ZDNet: SuSE 7.3 offers solid server reach and desktop usability 
           </title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-16-001-20-RV-SS 
           </link> 
           <description> 
               "SuSE Linux 7.3 is well prepared for corporate computing, offering 
               support for a broad range of server architectures and significant 
               advances in usability for both administrators and end users. 
               Companies looking for a solid server platform--and perhaps even a 
               desktop replacement for Windows--would be well advised to evaluate 
               SuSE 7.3's stellar offerings." 
           </description> 
       </item> 
       <item> 
           <title>Linux 2.4.18-pre4 Released</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-15-025-20-NW-KN 
           </link> 
           <description>Changelog, link within.</description> 
       </item> 
       <item> 
           <title>Linux 2.5.3-pre1 Released</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-15-024-20-NW-KN 
           </link> 
           <description>Changelog, link within.</description> 
       </item> 
       <item> 
           <title> 
               LinuxProgramming: Tcl-URL! - weekly Tcl news and links (Jan 15) 
           </title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-15-023-20-PS 
           </link> 
           <description>All the latest news from the Tcl world.</description> 
       </item> 
       <item> 
           <title>MLUG.ca: Up2date with RedHat</title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-15-022-20-PS-RH-SW 
           </link> 
           <description> 
               "What up2date does is similar to what Debian has been doing for years 
               now, namely, finding updates and installing packages without having 
               dependency issues. For those who have used Debian I'm refering to 
               the program apt-get which does exactly what up2date does. Some might 
               argue that apt-get is a better program, but I certainly don't want 
               to start a holy war." 
           </description> 
       </item> 
       <item> 
           <title> 
               Call for papers out for Ottawa Linux Symposium 2002 
           </title> 
           <link> 
            http://linuxtoday.com/news_story.php3?ltsn=2002-01-15-021-20-NW-CY-DV 
           </link> 
           <description> 
               "OLS is Linux and Linux related software developers symposium with a 
               strong focus on emerging technologies, research projects, and works 
               in progress. We invite contribution from the free software and 
               commercial developers." 
           </description> 
       </item> 
       <item> 
           <title> 
               Newsforge: Community commentary: The case for 'lagom' copyright 
           </title> 
           <link> 
               http://linuxtoday.com/news_story.php3?ltsn=2002-01-15-021-20-OP-LL 
           </link> 
           <description> 
               "One of the big issues of free software during 2001 was whether Richard 
               M Stallman was for or against a codified GNU GPL. Hence, did 
               Stallman --the father of Free Software -- propagate a law to support 
               his beliefs?" 
           </description> 
       </item> 
       <textinput> 
           <title>Search</title> 
           <description>Search Linux Today:</description> 
           <name>query</name> 
           <link>http://linuxtoday.com/search.php3</link> 
       </textinput> 
   </channel> 
</rss>
```

<b><i>Упътване</i></b>

```css
След като зададете стилове по подразбиране, предефинирайте (в края на документа!) същите стилове като използвате 
@media screen and (min-width: 480px) { ... } 
и 
@media print {...} 
```

<h4>Задача 4: За дадения по-долу HTML документ, използвайки различни според случая CSS селектори (прости селектори, контекстови селектори, класове, селектори от тип пряк наследник, "брат/сестра", за атрибути и т.н.), създайте CSS дефиниция, която приложена върху него го форматира със същия изглед както на фигурата по-долу:</h4>

```html
<?xml version="1.0" encoding="UTF-8"?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
   <head> 
      <title>Test file for sample 3</title> 
      <link rel="stylesheet" href="task4.css" type="text/css"/> 
   </head> 
   <body> 
      <p>Only in the first paragraph: a green backround and yellow color.</p> 
      <p lang="en-us">A black paragraph when the lang attribute is available.</p> 
      <p>A brown paragraph in the default case.</p> 
      <p class="warning"> 
         <span lang="en-us">A green span</span> in a red paragraph. 
      </p> 
      <p class="warning"> 
         <span>A yellow background and blue color</span> in a red paragraph. 
      </p> 
      <p id="maincontent" lang="en-gb"> 
         <span class="warning">A red span</span> in a green paragraph. 
      </p> 
      <div>This is not red, but orange.</div> 
      <p> 
         Here is a blue paragraph. Here is a blue paragraph. Here is a blue paragraph. Here is a blue paragraph.<br> 
         Here is a blue paragraph. Here is a blue paragraph. Here is a blue paragraph. Here is a blue paragraph.<br> 
         Here is a blue paragraph. Here is a blue paragraph. Here is a blue paragraph. Here is a blue paragraph. 
      </p> 
      <span>Here is some span with css definition in the default case.</span> 
      <div>And here is a red div!</div> 
      <code>More code... with css definition in the default case.</code> 
      <div>And this is a green div!</div> 
   </body> 
</html>
```

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%209/exercises/images/task4.png"/>

<h4>Задача 5: За дадения по-долу HTML документ, използвайки подходящи според случая стойности за margin, padding, border и други CSS свойства, създайте CSS дефиниция, която приложена върху него го форматира със същия изглед както на фигурата по-долу:</h4>

```html
<?xml version="1.0" encoding="UTF-8"?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
   <head> 
      <title>Exercise 5</title> 
      <link rel="stylesheet" href="task5.css" type="text/css"/> 
   </head> 
   <body> 
      <h1>Brad Pitt</h1> 
      <div id="blockSection"> 
         <img class="picture" 
	      src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Angelina_Jolie_Brad_Pitt_Cannes.jpg/220px-Angelina_Jolie_Brad_Pitt_Cannes.jpg"> 
         <img class="picture" src="https://i0.wp.com/eju.tv/wp-content/uploads/2011/10/brad_pitt.jpg"> 
      </div> 
      <div id="text"> 
         <p> 
            <span class="boldAndUnderline">William Bradley Pitt (born December 18, 1963) is an American actor and 
		producer.</span> As a public figure, Pitt has been cited as one of the most influential and powerful 
		people in the American entertainment industry. 
         </p> 

         <p> 
            <span class="boldAndUnderline">Pitt first gained recognition as a cowboy hitchhiker in the road movie Thelma & Louise
		(1991). His first leading roles in big-budget productions came with the drama films A River Runs Through It (1992) 
		and Legends of the Fall (1994), and horror film Interview with the Vampire (1994). He gave critically acclaimed 	
		performances in the crime thriller Seven and the science fiction film 12 Monkeys (both 1995), the latter earning him
		a Golden Globe Award for Best Supporting Actor and an Academy Award nomination. Pitt starred in the cult film Fight 
		Club (1999) and the heist film Ocean's Eleven (2001) and its sequels, Ocean's Twelve (2004) and Ocean's Thirteen (2007).
		His greatest commercial successes have been Troy (2004), Mr. & Mrs. Smith (2005), and World War Z (2013). Pitt received
		his second and third Academy Award nominations for his leading performances in The Curious Case of Benjamin Button(2008)
		and Moneyball (2011). He produced The Departed (2006) and 12 Years a Slave (2013), both of which won the Academy Award
		for Best Picture, and also The Tree of Life, Moneyball, and The Big Short (2015), all of which garnered Best Picture
		nominations. 
         </p> 
      </div> 
       
      <div id="text"> 
         <p> 
            <span class="boldAndUnderline">In the late 1980s and early 1990s</span>, Pitt was involved in successive relationships with
		several of his co-stars, including Robin Givens (Head of the Class), Jill Schoelen (Cutting Class), and Juliette Lewis
		(Too Young to Die? and Kalifornia). In addition, Pitt had a much-publicized romance and engagement to his Seven co-star,
		Gwyneth Paltrow, whom he dated from 1994 to 1997. 
         </p> 

         <p> 
            <span class="boldAndUnderline">Pitt met Friends actress Jennifer Aniston in 1998 and married her in a private wedding
		ceremony in Malibu on July 29, 2000. In January 2005, Pitt and Aniston announced they had decided to separate. Two
		months later, Aniston filed for divorce, citing irreconcilable differences. </span>Pitt and Aniston's divorce was
		finalized by the Los Angeles Superior Court on October 2, 2005. Despite media reports that Pitt and Aniston had an
		acrimonious relationship, Pitt said in a February 2009 interview that he and Aniston "check in with each other", adding
		that they were both big parts of each other's lives. 
         </p> 
      </div> 
   </body> 
</html>
```

<img src="https://github.com/ngadzheva/XML-labs/blob/master/week%209/exercises/images/task5.png"/>

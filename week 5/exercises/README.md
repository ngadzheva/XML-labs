<!-- Header -->
<header> 
  <h1><b>DOM, SAX и StAX</b></h1>
</header>

<!-- Content -->
## Цели на упражнението:
		
```
1. Използване на основни DOM, SAX и StAX интерфейси
```

<br/>

<h4>Задача 1: Като използвате SAX, принтирайте дадения по-долу XML документ в стандартната конзола, спазвайки следните условия:</h4>

```
1. Йерархията на елементите да бъде запазена
2. Всеки елемент да бъде разпечатан на нов ред заедно с включените в него атрибути
3. Текстовите стойности на елементите да бъдат разпечатани с главни букви
```
    
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


<h4>Задача 2: Като използвате SAX, имплементирайте валидация на XML документa от <i>задача 1</i>, която проверява дали са изпълнени следните условия:</h4>

<pre>
1. Всеки елемент <b><i>item</i></b> трябва да съдържа едно множество от под-елементите <b><i>title</i></b>, <b><i>link</i></b> и <b><i>description</i></b>, всеки от тях срещащ се точно един път
2. Стойността на атрибута <b><i>version</i></b> (принадлежащ на елемента <b><i>rss</i></b>) трябва да бъде цяло положително число
3. Елементът <b><i>channel</i></b> трябва да съдържа поне 2 и не повече от 10 под-елемента <b><i>item</i></b>
4. Разпечатайте информация за мястото (номер на ред и колона), на което грешката се среща
</pre>

<b>Упътване: </b>

```java
За отпечатване на ред и колона използвайте locator.getLineNumber() и locator.getColumnNumber()
```
 
<h4>Задача 3: Като използвате SAX, трансформирайте XML документa от <i>задача 1</i> в HTML документ, използвайки за изход стандартната конзола. Новият HTML документ трябва да съдържа таблица със следното съдържание:</h4>
<pre>
1. Три колони с имена <b><i>title</i></b>, <b><i>link</i></b> и <b><i>description</i></b>
2. По един ред за всеки елемент <b><i>item</i></b> със стойностите на под-елементите му <b><i>title</i></b>, <b><i>link</i></b> и <b><i>description</i></b>
</pre>

<h4>Задача 4: Решете <i>задача 1</i>, като вместо SAX използвате DOM</h4>
  
<h4>Задача 5:  Използвайки DOM, променете XML документa от <i>задача 1</i>, по следния начин:</h4>

<pre>
1. Превърнете под-елемента <b><i>link</i></b> на елемента <b><i>item</i></b> в негов атрибут
2. Запазете първите 10 <b><i>item</i></b> елементa, а всички останали ги изтрийте
3. Добавете нов под-елемент <b><i>sponsor</i></b> на елемента <b><i>channel</i></b>
</pre>

<h4>Задача 6: Решете <i>задача 1</i>, като използвате StAX</h4>

<h4>Задача 7: Използвайки StAX, създайте по-долу дадения XML документ:</h4>

```xml
<?xml version="1.0"?>
<bookstore>
  <book category="COOKING">
    <title lang="en">Everyday Italian</title>
    <author>Giada De Laurentiis</author>
    <year>2005</year>
    <price>30.00</price>
 </book>
 <book category="CHILDREN">
    <title lang="en">Harry Potter</title>
    <author>J K. Rowling</author>
    <year>2005</year>
    <price>29.99</price>
  </book>
  <book category="WEB">
    <title lang="en">Learning XML</title>
    <author>Erik T. Ray</author>
    <year>2003</year>
    <price>39.95</price>
  </book>
</bookstore>
```
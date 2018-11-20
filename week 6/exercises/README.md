<!-- Header -->
<header> 
  <h1><b>XLink, XPointer, XInclude</b></h1>
</header>

<!-- Content -->
## Цели на упражнението:
		
```
1. Използване на XLink, XPointer и XInclude
```

<br/>

<h4>Задача 1: Създайте XML документ, който чрез XInclude включва дадените по-долу два XML документа и е валиден спрямо дадената по-долу XML схема.</h4>
    
```xml
<?xml version="1.0"?> 
<chapter> 
   <content> 
      Introduction 
   </content> 
</chapter>
```

```xml
<?xml version="1.0"?> 
<chapter> 
   <content> 
      Chapter 1 
   </content> 
</chapter>
```

```xml
<?xml version="1.0" encoding="UTF-8"?> 
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified"> 
   <xs:element name="book"> 
      <xs:complexType> 
         <xs:sequence> 
            <xs:element ref="chapters"/> 
         </xs:sequence> 
      </xs:complexType> 
   </xs:element> 
   <xs:element name="chapters"> 
      <xs:complexType> 
         <xs:sequence> 
            <xs:element maxOccurs="unbounded" ref="chapter"/> 
         </xs:sequence> 
      </xs:complexType> 
   </xs:element> 
   <xs:element name="chapter"> 
      <xs:complexType> 
         <xs:sequence> 
            <xs:element ref="content"/> 
         </xs:sequence> 
      </xs:complexType> 
   </xs:element> 
   <xs:element name="content" type="xs:NCName"/> 
</xs:schema>
```


<h4>Задача 2: Създайте XML документ, който чрез XPointer и XLink дефинира връзки, които се отварят в нов прозорец, към елементите number на дадения по-долу XML документ и е валиден спрямо дадената по-долу XML схема. </h4>

```xml
<?xml version="1.0" encoding="UTF-8"?> 
<numbers> 
   <number id="number1">1</number> 
   <number id="number2">2</number> 
</numbers>
```

```xml
<?xml version="1.0" encoding="UTF-8"?> 
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified" xmlns:xlink="http://www.w3.org/1999/xlink"> 
   <xs:import namespace="http://www.w3.org/1999/xlink" schemaLocation="xlink.xsd"/> 
   <xs:element name="book"> 
       <xs:complexType> 
           <xs:sequence> 
               <xs:element ref="chapters"/> 
           </xs:sequence> 
       </xs:complexType> 
   </xs:element> 
   <xs:element name="chapters"> 
       <xs:complexType> 
           <xs:sequence> 
               <xs:element maxOccurs="unbounded" ref="chapter"/> 
           </xs:sequence> 
       </xs:complexType> 
   </xs:element> 
   <xs:element name="chapter"> 
       <xs:complexType> 
           <xs:sequence> 
               <xs:element ref="content"/> 
           </xs:sequence> 
           <xs:attribute ref="xlink:href" use="required"/> 
           <xs:attribute ref="xlink:show" use="required"/> 
           <xs:attribute ref="xlink:type" use="required"/> 
       </xs:complexType> 
   </xs:element> 
   <xs:element name="content" type="xs:string"/> 
</xs:schema>
```
 
<h4>Задача 3: По-долу е даден SVG документ, дефиниращ кръг (с id="circle") и правоъгълник (с id="retangle"). Създайте HTML документ и включете в него тези две фигури, използвайки XLink.</h4>

```xml
<?xml version="1.0" encoding="utf-8"?> 
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"> 
<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="176" height="32" viewBox="0 0 176 32"> 
   <circle cx="50" cy="50" r="40" stroke="black" stroke-width="3" fill="red" id="circle"/> 
   <rect width="300" height="100" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)" id="retangle"/> 
</svg>
```

<b>Упътване: </b>

```xml
Използвайте браузър, поддържащ SVG, като напр. IE 9, 10, 11, Firefox. 
Синтаксис за включване на SVG елемент в HTML документ: <svg><use xlink:href="pathToSVGFile#idName" /></svg>
```
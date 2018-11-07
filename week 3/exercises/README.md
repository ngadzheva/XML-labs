<!-- Header -->
<header> 
  <h1><b>XML валидация чрез XML Schema</b></h1>
</header>

<!-- Content -->
## Цели на упражнението:
		
```
1. Създаване на XML схема
2. Валидация на XML документ с XML Schema
3. Дефиниране на прости и комплексни типове
4. Задаване на ограниченя върху предефинираните типове
5. Използване на разширени типове и предефиниране на типове
6. Използване на анотации, нотации, регулярни изрази
7. Импортиране на XML схеми от други пространства от имена       
```

<br/>

<h4>Задача 1: Превърнете дадения по-долу DTD документ в XML Schema. Създайте XML екземпляр на тази схема и я валидирайте.</h4>
    
```xml
<!ELEMENT collection (description,recipe*)>
<!ELEMENT description ANY>
<!ELEMENT recipe (title,ingredient*,preparation,comment?,nutrition)>
<!ELEMENT title (#PCDATA)>
<!ELEMENT ingredient (ingredient*, preparation?)>
<!ATTLIST ingredient 
    name CDATA #REQUIRED
    amount CDATA #IMPLIED
    unit CDATA #IMPLIED
>
<!ELEMENT preparation (step*)>
<!ELEMENT step (#PCDATA)>
<!ELEMENT comment (#PCDATA)>
<!ELEMENT nutrition EMPTY>
<!ATTLIST nutrition 
    protein CDATA #REQUIRED
    carbohydrates CDATA #REQUIRED
    fat CDATA #REQUIRED
    calories CDATA #REQUIRED
    alcohol CDATA #IMPLIED
>
```

<h4>Задача 2: Даденият по-долу XML документ описва типовете сметки, които поддържа една примерна банка, нейните клиенти и сметките, 
които те имат. За този XML документ създайте XML Schema, която изпълнява следните условия:</h4>

<pre>
1. Редът на срещане на под-елементите на <b><i>bank</i></b> (<b><i>accounts</i></b>, <b><i>customers</i></b> и <b><i>customer_accounts</i></b>) и 
   <b><i>accounts</i></b> (<b><i>saving_accounts</i></b> и <b><i>checking_accounts</i></b>) няма значение
2. Всяка сметка има уникален идентификатор
3. Всеки клиент има уникален идентификатор
4. Балансът на сметката не може да бъде по-малък от -5000 - за това условие използвайте рестрикция на 
   съществуващите предефинирани типове
5. Атрибутът <b><i>c_id</i></b> реферира към съответния клиент, а <b><i>ac_id</i></b> към съответната му сметка
6. Дефинирайте елементите <b><i>customers</i></b> и <b><i>saving_account</i></b> като комплексен глобален тип, а елемента <b><i>accounts</i></b> като 
   комплексен локален тип
</pre>

```xml
<?xml version="1.0" encoding="UTF-8"?> 

<bank> 
   <accounts> 
   	   <saving_accounts> 
   	   	   <saving_account id="a1" interest="0.03"> 
   	   	   	   <balance>2500</balance> 
   	   	   </saving_account> 
   	   	   <saving_account id="a2" interest="0.03"> 
   	   	   	   <balance>15075</balance> 
   	   	   </saving_account> 
   	   </saving_accounts> 
   	   <checking_accounts> 
   	   	   <checking_account id="a3"> 
   	   	   	   <balance>4025</balance> 
   	   	   </checking_account> 
   	   	   <checking_account id="a4"> 
   	   	   	   <balance>-125</balance> 
   	   	   </checking_account> 
   	   	   <checking_account id="a5"> 
   	   	   	   <balance>325</balance> 
   	   	   </checking_account> 
   	   </checking_accounts> 
   </accounts> 
   <customers> 
   	   <customer id="c1"> 
   	   	   <name>Ben Richerdson</name> 
   	   	   <address>Park Drive 2</address> 
   	   </customer> 
   	   <customer id="c2"> 
   	   	   <name>Marc Wretcher</name> 
   	   	   <address>Mill Drive 75</address> 
   	   </customer> 
   	   <customer id="c3"> 
   	   	   <name>Angel Steady</name> 
   	   	   <address>Lake Sight 15</address> 
   	   </customer> 
   </customers> 
   <customer_accounts> 
   	   <customer_account c_id="c1" ac_id="a2"/> 
   	   <customer_account c_id="c1" ac_id="a3"/> 
   	   <customer_account c_id="c2" ac_id="a4"/> 
   	   <customer_account c_id="c3" ac_id="a1"/> 
   	   <customer_account c_id="c3" ac_id="a5"/> 
   </customer_accounts> 
</bank>
```
 
<h4>Задача 3: В XML схемата от <i>задача 2</i> направете следните промени:</h4>
<pre>
1. Дефинирайте два прости типа, задаващи горна и долна граница на стойността на елемента <b><i>balance</i></b>. 
   След това променете дефиницията на елемента <b><i>balance</i></b>, като го представите като обединение на тези два прости типа.
2. Използвайки разширени типове на XML Schema, създайте нов тип <b><i>customerExt</i></b>, който разширява дефиницията на типа 
   <b><i>customer</i></b>, като добавя нов негов под-елемент <b><i>contacts</i></b>, който от своя страна се състои от 2 под-елемента - 
   <b><i>email</i></b> и <b><i>telephone</i></b>. Използвайте новия тип <b><i>customerExt</i></b> вместо <b><i>customer</i></b> и запишете новата XML схема под името 
   <b><i>bank.xsd</i></b>.
3. Създайте нова XML схема, която предефинира типа <b><i>balance</i></b> и <b><i>customerExt</i></b> от външната за нея XML схема - <b><i>bank.xsd</i></b>. 
   Новият тип <b><i>balance</i></b> не трябва да бъде по-малък от -5200, a новият тип <b><i>customerExt</i></b> съдържа допълнително нов 
   под-елемент <b><i>image</i></b> от тип <b><i>base64Binary</i></b>, който има един атрибут <b><i>src</i></b> от тип <b><i>string</i></b>. Запишете новата XML схема под 
   името <b><i>bankExt.xsd</i></b>.
4. Добавете няколко анотации в по-горе създадената XML схема (<b><i>bank.xsd</i></b>) към избрани от вас комплексни типове, 
   описващи тяхното предназначение.
</pre>

<h4>Задача 4: Редактирайте XML схемата от <i>задача 3</i> (bank.xsd), като добавите елемент <i>postalCode</i> към комплексния тип <i>customer</i> и включите регулярен израз за:</h4>
<pre>
1. пощенски код (четири цифрено число, например:1000) 
2. телефон (например в следния формат:+359-02-989-14-04)
3. електронна поща
</pre>
<b><i>Упътване:</i></b>

<b> Синтаксис за използване на регулярен израз: </b>

```xml
<xsd:restriction base="XXXX">
   <xsd:pattern value="Regular_Expression"/>
</xsd:restriction>
```

  
<h4>Задача 5:  Редактирайте XML схемата от <i>задача 3</i> (bankExt.xsd), като добавите към елемента <i>image</i> атрибут <i>type</i> от тип нотация. Създайте XML инстанция на новата схема и валидирайте.</h4>

<b><i>Упътване:</i></b>

<b> Синтаксис за дефиниране на нотации в XML схема: </b>

```xml
<notation id=ID name=NCName public=anyURI system=anyURI any attributes>(annotation?)</notation>
```
  
<h4>Задача 6:  Съставете XML Schema, която включва схеми от други пространства от имена. Създайте XML екземляр (инстанция) на тази схема и го валидирайте.</h4>

<b><i>Упътване:</i></b>

<b> Синтаксис за импортиране на външна схема: </b>

```xml
<import id=ID namespace=anyURI schemaLocation=anyURI any attributes >(annotation?)</import>
```

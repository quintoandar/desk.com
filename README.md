desk.com
===========

A series of libs that wrap Desk.com APIs.

Mvn Usage
-----
First add the repository:

```xml
<repositories>
  ...
  <repository>
    <id>QuintoAndar Repo Desk.com</id>
    <url>https://raw.githubusercontent.com/quintoandar/desk.com/master/mvn-repo</url>
  </repository>
  ...
</repositories>
  
```

Then add the dependency artifact:

```xml
<dependencies>
  ...
  <dependency>
    <groupId>br.com.quintoandar</groupId>
    <artifactId>desk.com</artifactId>
    <version>1.1.0-SNAPSHOT</version>
  </dependency>
  ...
</dependencies>
```

desk.com Usage
-----

## DeskApiWrapper
```java
DeskApiWrapper wrap = new DeskApiWrapper("https://yoursite.desk.com");
String[] access =  {"acessKey","accessSecret"};
wrap.setAccess(access[0],access[1]);
String[] token =  {"yourTokenKey","yourTokenSecret"};
wrap.setToken(token[0],token[1]);
wrap.init();
```
Or basic auth:
```java
DeskApiWrapper wrap = new DeskApiWrapper("https://yoursite.desk.com");
wrap.setBasicAuth("user","pass");
wrap.init();
```

### Usage

```java
Case c = new Case();
c.setStatus(CaseStatus.open);
c.setType(CaseType.chat);
c.setPriority(6);
c.setSubject("Question about life universe and everything");
c.setCreatedAt(new Date());

Message m = new Message();
m.setFrom("everyone@world.com");
m.setTo("deeptought@computers.com");
m.setBody("What is the anwser to life, universe and everything?");
m.setStatus(MessageStatus.received);
m.setDirection(MessageDirection.in);
c.setMessage(m);

//assuming you created a previous customer
customer.addToLinks(c.getLinks(), "customer");
case = wrap.newCase(customer, case);

```

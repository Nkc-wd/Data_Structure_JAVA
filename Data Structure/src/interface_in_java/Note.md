It is way of achieving  multiple inheritance in java.

**However Multiple inheritance is not possible in java**
   
An Interface is basically a kind of class, But in interface all memeber's are **final** and **static**
and methods are abstract.

In interface we will give body of method as initialization.

**interface reserve the behavior for classes that implement them.**

It also take care of return type of method that is written in interface.

>> methods declared in an interface are always public and abstract.

>> static methods can not be declared in interface **but variable does**.


**Important**

we can not initialize interface class as new class

xxxxxxxxxxxxxxxxxxxxxxxx

One one=new One();

xxxxxxxxxxxxxxxxxxxxxxx


** We can not make constructor in interface**.

Variables of interface can be call by 

**interface.variable_name**


**interface from other interface**

>> interface I1 extends I2{
      //........
      }
 
**interface implements by class**

>> class One implements Two{
      //.......
      }
       
      
  
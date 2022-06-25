<h1>Proyecto final laboratorio tercer cuatrimestre</h1>
Este proyecto consiste en un sistema de gestion para supermercado, en el cual tenemos una parte de administración y otra de ventas. 
La parte de administración consiste en la gestion de usuarios, donde tenemos dos tipos Administrador y Cajeros, estos dos heredan de la clase empleado 
(la cual es una clase abstracta).

El administrador cuenta con las siguientes funcionalidades: 

* dar de baja
* dar de alta
* agregar usuario
* listar
* getLog

Como medida de seguridad, ya que los empleados se gestionan en un contenedor de empleados, el unico que puede acceder al contenedor y modificarlo es el administrador, 
mediante un sistema interno de chequeo.

Luego tenemos para la parte de gestion de caja la clase stock (que es un contenedor de productos) y la clase productos, que son los que se pueden comprar, vender,
agregar y quitar.

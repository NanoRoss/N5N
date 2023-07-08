# Automation Framework N5N
### Comenzando 🚀

```
A continuación se presenta la documentación de los dos tests creados como asi tambien de la tecnologia implementada.
```
### Tecnologia Implementada 📋
```

Maven: Para todo lo que es build del código y gestion de dependencias y librerias. 
TestNG: Para todo lo que son las assertion y estructura de los tests.
Java: Como lenguaje de programacion principal. 
Selenium: Como driver entre el codigo y la interaccion con los WebElements.
BDD: Se implemento con BDD Behavior Driven Development mediante Cucumber+Gherkin
Page Object Model: Patron de diseño que permite modelar las páginas y sus comportamientos fomentando la mantenibilidad 
y escalabilidad dando las responsabilidades a las clases pages.
Extenet Report: Como Libreria principal para el reporte. 
```

### Flujo Basico del Framework ⚙️
```
1) Partimos de los features files con la descripcion de los Escenarios y Steps con Gherkin
2) Cada Step esta realacionado (por el nombre) con un metodo de una clase de Step Definition. 
3) En cada Step Definition class mediante Inyección de dependencias:
 
 a) instanciamos la BaseClass y obtenemos el driver.
 b) instanciamos las clases pages requeridas pasandoles el driver.

 public GoogleHomeSteps(BasePage basePage) {
        this.basePage = basePage;
        this.driver = basePage.getDriver();
        this.googleHome_page = new GoogleHome_Page(basePage.getDriver());
    }

4) Mediante Hooks @before @after antes y despues de cada escenario se ejecuta el setUp y el TearDown para iniciar y finalizar el driver.
5) Cada clase Page nace con el driver en su constructor y puede inicializar la clase Helper.

public GoogleHome_Page(WebDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers(driver);
    }
```

### Ejecutando nuestras Suites y Analizando reportes ⚙️
```
Para la ejecucion formal, debemos ejecutar la clase RunTest.
Al finalizar la ejecucion se viaualizara un reporte html en test-output con imagenes incluidas en base64.
Si por algun motivo, durante la ejecuicion se manifieta un error el framework dejara una imagen del mismo en /Screenshots.
```

### Pruebas Realizadas ⚙️
```
Test 1: Validación básica de la página de inicio de Netflix
Este test verifica que la página de inicio de Netflix tenga la URL y el título esperados.

Escenario:
Nombre: As a user go to Netflix website and validate the site's title and URL
Descripción: Como usuario, acceder al sitio web de Netflix y validar el título y la URL del sitio.

Pasos:
Dado que estoy en la página de búsqueda de Google.
Cuando ingreso el criterio de búsqueda.
Y hago clic en el botón de búsqueda.
Y accedo a Netflix Argentina en los resultados de Google.
Entonces valido la URL: "https://www.netflix.com".
Entonces valido el título de la página: "Películas y series ilimitadas y mucho más". 

----------------------------------------------

Test 2: Inicio de sesión en Netflix con credenciales inválidas
Este test verifica que un usuario no pueda iniciar sesión en Netflix utilizando credenciales inválidas y que se muestre un mensaje descriptivo.

Escenario:
Nombre: As a user go to Netflix website and login with invalid credentials
Descripción: Como usuario, acceder al sitio web de Netflix y realizar un intento de inicio de sesión con credenciales inválidas.

Pasos:
Dado que estoy en la página de búsqueda de Google.
Cuando ingreso el criterio de búsqueda.
Y hago clic en el botón de búsqueda.
Y accedo a Netflix Argentina en los resultados de Google.
Y inicio sesión con el usuario "FakeUser123" y la contraseña "FakePass123".
Entonces el usuario no puede iniciar sesión y ve un mensaje descriptivo.
```

 
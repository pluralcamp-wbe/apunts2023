# spring-mvc-simple

Spring MVC simple example with servlets and jsp.

It involves three endpoints:

- ``'/'`` root endpoint maps the **index.jsp** view with html forms.
- ``'/hello'`` endpoint maps the **helloworld.jsp** view. The controller method returns a ``ModelAndView`` object, specifying the view in the constructor.
-  ``'/servertime'``  endpoint maps the **servertime.jsp** view. The controller method returns a ``String`` which is the name of the view.

Steps:

1. Creating the project and adding dependencies using maven.
2. Introducing JSP pages with html forms (index) and the  ``Front Controller / Dispatcher Servlet``.
3. Introducing the **Controller** with its ``Handler Mappings``.
4. Introducing the results JSP pages (helloworld and servertime) with the ``View Resolver`` (using ``ModelAndView`` or ``String`` objects).



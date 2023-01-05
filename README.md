# testGlueDigital

Para la realización de la prueba se ha adjuntado una captura de la covertura analizada y un fichero json con la colección postman para realizar una prueba a través de este. Se ha realizado unos test cortos en los que se prueba el servicio, habría que realizar pruebas para el controlador y el repositorio (este es fake por lo que realmente carece de sentido) pero se han omitidos para no alargar más la prueba.

Respecto al planteamiento se ha seguido el Patrón Criteria utilizando 3 criterios (2 específicos y uno general). El motivo por el que dar los criterios específicos implementados completamente es pensando en futuros evolutivos que pudieran dar pie a ello. Así, si se quisiera tener endpoint específicos para utilizar los criterios por separado no sería necesario invertir tiempo en la implementación del criterio sino solo de la estructura de controlador y servicio. En caso de querer aplicar un nuevo criterio bastaría simplemente con implementar el criterio específico y en el general añadir la implementación (Corta) para tenerlo en cuenta.

Para cualquier duda que surja podemos o bien hablarlo por llamada o enviarme un correo.

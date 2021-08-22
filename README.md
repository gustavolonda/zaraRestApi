# Zara Api REST

### Programming language
<code><img height="40" src="https://i.blogs.es/6091fa/java/1366_2000.jpg" title="Java"></code>

### Framework
<code><img height="40" src="https://geeksjavamexico.files.wordpress.com/2017/09/spring-framework.png?w=640" title="Spring Boot"></code>

### IDE
<code><img height="40" src="https://alternativas-a.com/wp-content/uploads/alternativas-a-Visual-Studio-Code-150x150.jpg" title="Visual Code"></code>

### Steps to run the project

#### 1. To run the project you must have installed

- Java Virtual Machine

- JDK 11

- Maven

#### 2. Data Used

- Post: localhost:8080/api/brand
    {
	"brandId":1,
	"brandName":"Zara Men"
    }

- Post: localhost:8080/api/product
    {
	"productId": 35455,
	"productName":"Jersey de ochos"
    }

- Post: localhost:8080/api/price/saveAll
   {"priceList":
                [{
                    "startDate":"2020-06-14-00.00.00",
                    "endDate" :"2020-12-31-23.59.59",
                    "brand": {"brandId":1
                },
                "product": {"productId":35455},
                "priority":0,
                "price":35.5,
                "curr":"EUR"

                },					
                {
                    "startDate":"2020-06-14-15.00.00",
                    "endDate" :"2020-06-14-18.30.00",
                    "brand": {"brandId":1
                },
                "product": {"productId":35455},
                "priority":1,
                "price":25.45,
                "curr":"EUR"

                },
                {
                    "startDate":"2020-06-15-00.00.00",
                    "endDate" :"2020-06-15-11.00.00",
                    "brand": {"brandId":1
                },
                "product": {"productId":35455},
                "priority":1,
                "price":30.5,
                "curr":"EUR"

                },
                {
                    "startDate":"2020-06-15-16.00.00",
                    "endDate" :"2020-12-31-23.59.59",
                    "brand": {"brandId":1
                },
                "product": {"productId":35455},
                "priority":1,
                "price":38.95,
                "curr":"EUR"

                }


                    ]
                
}
- Get: localhost:8080/api/price/dateApplyPrice/2020-06-14-10.00.00/35455/1
        localhost:8080/api/price/dateApplyPrice/{Date}/{ProductID}/{BrandID}






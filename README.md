# JAVA Currency Converter
The web application for foreign currency exchanging, implemented by [Spring Boot](https://spring.io/projects/spring-boot), [Bootstrap](https://getbootstrap.com/), and the back-end is supported by [ExchangeRates API](https://exchangeratesapi.io/).

The application can be tested on browsers, and as a RESTful API, which will require three inputs:
- A source currency
- A target currency
- A monetary value

---

## Getting Started
- Place the ExchangeRates API key in the `Constants` class file:
```java
public class Constants {
    //...

    public static final String API_KEY = "YOUR_API_KEY";        //TODO: Replace with your ExchangeRates API key here
    
    //...
}
```
- Run the project.
- The application should work at the address `http://localhost:8080/`.

## Testing
### Front-end
Locate to `http://localhost:8080/convert` or click on the **Convert** button from the index page to test.

### Back-end
Test at the address `http://localhost:8080/convert` with the following parameters:
- `"source"`: The base currency ("USD", "EUR", etc.)
- `"target"`: The desired currency
- `"amount"`: The money amount for conversion
The result should show at the field `"convertedValue"`.

*Example*: Get `http://localhost:8080/convert?source=EUR&target=USD&amount=10` to convert 10EUR to USD.

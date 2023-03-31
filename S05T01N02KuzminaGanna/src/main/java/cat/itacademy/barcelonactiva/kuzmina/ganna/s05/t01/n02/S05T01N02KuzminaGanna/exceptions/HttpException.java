package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class HttpException extends RuntimeException{
    private final HttpStatus status;

    public HttpException(HttpStatus status,String message) {
        super(message);
        this.status = status;
    }
}

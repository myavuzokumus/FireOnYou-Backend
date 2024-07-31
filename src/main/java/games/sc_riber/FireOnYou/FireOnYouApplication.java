package games.sc_riber.FireOnYou;

import games.sc_riber.FireOnYou.core.utilities.exceptions.BusinessException;
import games.sc_riber.FireOnYou.core.utilities.exceptions.ProblemDetails;
import games.sc_riber.FireOnYou.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class FireOnYouApplication {

	public static void main(String[] args) {
		SpringApplication.run(FireOnYouApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails handleException(BusinessException exception) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(exception.getMessage());
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return validationProblemDetails;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}

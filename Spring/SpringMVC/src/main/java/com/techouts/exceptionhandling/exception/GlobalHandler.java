    package com.techouts.exceptionhandling.exception;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.ControllerAdvice;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.ResponseBody;

    import java.util.HashMap;
    import java.util.Map;

    @ControllerAdvice
    public class GlobalHandler {
        @ExceptionHandler(NullPointerException.class)
        @ResponseBody
        public ResponseEntity<Map<String,Object>> handleNullPointerException(NullPointerException e, Model model) {
//            model.addAttribute("message",e.getMessage());
//            return "exception/Login";
                Map<String, Object> body = new HashMap<>();
                body.put("status", HttpStatus.BAD_REQUEST.value());
                body.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
                body.put("message", e.getMessage());
                return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

        }
    }


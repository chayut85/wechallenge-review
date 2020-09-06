
package com.example.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping("/reviews/{id}")
	public String getReviewById(@PathVariable int id) {
		return String.format("Hello %d!", id);
	}

	@GetMapping("/reviews")
	public String [] getReviewByText(@RequestParam("query") String text) {
		String [] array = new String [1];
		array[0] = text;
		return array;
	}

	@PutMapping("/reviews/{id}")
	public String updateReview(@PathVariable int id, @RequestBody String review){
		return String.format("%d %s", id, review);
	}

}
            
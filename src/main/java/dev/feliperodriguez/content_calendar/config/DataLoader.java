package dev.feliperodriguez.content_calendar.config;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.feliperodriguez.content_calendar.model.Content;
import dev.feliperodriguez.content_calendar.repository.ContentRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;

    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    /*//@Override
    //public void run(String... args) throws Exception {
        try (InputStream InputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            repository.saveAll(objectMapper.readValue(InputStream, new TypeReference<List<Content>>() {
            }));
        }

    }//*/

    @Override
    public void run(String... args) throws Exception {
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            List<Content> contentsFromFile = objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {});

            for (Content content : contentsFromFile) {
                // Verifica si el contenido ya existe en la base de datos
                List<Content> existingContent = repository.findAllByTitleContains(content.getTitle());
                if (existingContent.isEmpty()) {
                    // Si el contenido no existe, guárdalo en la base de datos
                    repository.save(content);
                } else {
                    // Si el contenido ya existe, puedes manejar esta situación como desees
                    // Por ejemplo, podrías imprimir un mensaje de registro indicando que el contenido ya existe
                    System.out.println("El contenido con el título '" + content.getTitle() + "' ya existe en la base de datos.");
                }
            }
        }
    }


}

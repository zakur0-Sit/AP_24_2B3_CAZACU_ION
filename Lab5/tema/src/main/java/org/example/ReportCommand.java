package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private final Person person;
    private final String outputFilePath;

    public ReportCommand(Person person, String path) {
        this.person = person;
        this.outputFilePath = path;
    }

    public Person execute() throws InvalidException {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        try {
            Template template = cfg.getTemplate("template.out");
            Map<String, Object> data = new HashMap<>();
            data.put("person", person);
            data.put("documents", person.getDocs());

            FileWriter writer = new FileWriter(outputFilePath);
            template.process(data, writer);
            writer.close();

            Desktop.getDesktop().open(new File(outputFilePath));


        } catch (IOException | TemplateException e) {
            throw new InvalidException(e);
        }
        return null;
    }
}

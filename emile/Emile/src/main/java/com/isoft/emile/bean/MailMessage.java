package com.isoft.emile.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailMessage implements Serializable {
    private String subject, text;
    private String to;
    private String attachmentFileName;
    private File attachmentFile;
}

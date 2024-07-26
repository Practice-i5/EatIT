package com.i7.eatit.domain.user.dto;

public class TechStackDTO {

    private String JavaScript;
    private String Python;
    private String Java;
    private String cSharp;
    private String Ruby;
    private String PHP;
    private String Swift;
    private String Kotlin;
    private String Go;
    private String Rust;

    public TechStackDTO() {
    }

    public TechStackDTO(String javaScript, String python, String java, String cSharp, String ruby, String PHP, String swift, String kotlin, String go, String rust) {
        this.JavaScript = javaScript;
        this.Python = python;
        this.Java = java;
        this.cSharp = cSharp;
        this.Ruby = ruby;
        this.PHP = PHP;
        this.Swift = swift;
        this.Kotlin = kotlin;
        this.Go = go;
        this.Rust = rust;
    }

    public String getJavaScript() {
        return JavaScript;
    }

    public void setJavaScript(String javaScript) {
        JavaScript = javaScript;
    }

    public String getPython() {
        return Python;
    }

    public void setPython(String python) {
        Python = python;
    }

    public String getJava() {
        return Java;
    }

    public void setJava(String java) {
        Java = java;
    }

    public String getcSharp() {
        return cSharp;
    }

    public void setcSharp(String cSharp) {
        this.cSharp = cSharp;
    }

    public String getRuby() {
        return Ruby;
    }

    public void setRuby(String ruby) {
        Ruby = ruby;
    }

    public String getPHP() {
        return PHP;
    }

    public void setPHP(String PHP) {
        this.PHP = PHP;
    }

    public String getSwift() {
        return Swift;
    }

    public void setSwift(String swift) {
        Swift = swift;
    }

    public String getKotlin() {
        return Kotlin;
    }

    public void setKotlin(String kotlin) {
        Kotlin = kotlin;
    }

    public String getGo() {
        return Go;
    }

    public void setGo(String go) {
        Go = go;
    }

    public String getRust() {
        return Rust;
    }

    public void setRust(String rust) {
        Rust = rust;
    }

    @Override
    public String toString() {
        return "TechStackDTO{" +
                "JavaScript='" + JavaScript + '\'' +
                ", Python='" + Python + '\'' +
                ", Java='" + Java + '\'' +
                ", CSharp='" + cSharp + '\'' +
                ", Ruby='" + Ruby + '\'' +
                ", PHP='" + PHP + '\'' +
                ", Swift='" + Swift + '\'' +
                ", Kotlin='" + Kotlin + '\'' +
                ", Go='" + Go + '\'' +
                ", Rust='" + Rust + '\'' +
                '}';
    }
}

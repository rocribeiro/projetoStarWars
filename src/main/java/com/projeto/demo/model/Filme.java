package com.projeto.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String linkFilme;
    @ManyToOne
    @JoinColumn(name="planeta_id")
    private Planeta planeta;

    public String getLinkFilme() {
        return linkFilme;
    }

    public void setLinkFilme(String linkFilme) {
        this.linkFilme = linkFilme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
}

package ca.cmpt213.as2;

import java.util.ArrayList;

/**
 * Tokimon Class includes all the private attributes towards Tokimon and all the methods to edit the class attributes
 */

public class Tokimon {
    private String name;
    private String id;
    private double score;
    private String comment;
    public ArrayList<Tokimon> team;
    private String extraComments;

    public Tokimon(String name, String id, double score, String comment) {
        this.name = name;
        this.id = id;
        this.score = score;
        this.comment = comment;
    }

    public Tokimon() {
        this.extraComments = "extra comments";
        this.team = new ArrayList<Tokimon>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ArrayList<Tokimon> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Tokimon> team) {
        this.team = team;
    }

    public String getExtraComments() {
        return extraComments;
    }

    public void setExtraComments(String extraComments) {
        this.extraComments = extraComments;
    }

    @Override
    public String toString() {
        return "Tokimon{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", team=" + team +
                ", extraComments='" + extraComments + '\'' +
                '}';
    }

    public void addMember(String name, String id, double score, String comment) {
        Tokimon firstTokimon = new Tokimon(name, id, score, comment);
        this.team.add(firstTokimon);
    }
}


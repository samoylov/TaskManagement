package tama.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // basic attributes
    private String name;
    private String description;

    // schedule
    @ManyToMany
    @JoinTable(name = "task_sequence", joinColumns = {
            @JoinColumn(name = "predecessor", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "successor", referencedColumnName = "id", nullable = false)})
    private List<Task> predecessors;

    @ManyToMany
    @JoinTable(name = "task_sequence", joinColumns = {
            @JoinColumn(name = "successor", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "predecessor", referencedColumnName = "id", nullable = false)})
    private List<Task> successors;

    // breakdown
    @ManyToMany
    @JoinTable(name = "task_breakdown", joinColumns = {
            @JoinColumn(name = "parent", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "child", referencedColumnName = "id", nullable = false)})
    private List<Task> parents;

    @ManyToMany
    @JoinTable(name = "task_breakdown", joinColumns = {
            @JoinColumn(name = "child", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "parent", referencedColumnName = "id", nullable = false)})
    private List<Task> children;

    // users
    @OneToOne
    private User creator;
    @OneToMany
    private List<User> assignee;

    public Task(String name) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(List<Task> predecessors) {
        this.predecessors = predecessors;
    }

    public List<Task> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Task> successors) {
        this.successors = successors;
    }

    public List<Task> getParents() {
        return parents;
    }

    public void setParents(List<Task> parents) {
        this.parents = parents;
    }

    public List<Task> getChildren() {
        return children;
    }

    public void setChildren(List<Task> children) {
        this.children = children;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getAssignee() {
        return assignee;
    }

    public void setAssignee(List<User> assignee) {
        this.assignee = assignee;
    }
}

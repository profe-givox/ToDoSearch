package net.ivanvega.todosearch;

import java.util.Objects;

public class ToDo {
    int id;
    String description;
    String createdDate;
    Boolean done;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return id == toDo.id &&
                Objects.equals(description, toDo.description) &&
                Objects.equals(createdDate, toDo.createdDate) &&
                Objects.equals(done, toDo.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createdDate, done);
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", done=" + done +
                '}';
    }
}

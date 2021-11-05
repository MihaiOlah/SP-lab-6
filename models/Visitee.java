package models;

import services.BookStatistics;

public interface Visitee {
    void accept(Visitor visitor);
    void accept(BookStatistics bookStatistics);
}

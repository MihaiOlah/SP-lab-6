package models;

import java.util.List;
import java.util.Objects;

public class Author {
    private final String name_;
    private final String surname_;

    public Author(String full_name)
    {
        name_ = Objects.requireNonNullElse(full_name, "");
        surname_ = "";
    }

    public Author(String name, String surname)
    {
        name_ = Objects.requireNonNullElse(name, "");
        surname_ = Objects.requireNonNullElse(surname, "");
    }

    public Author(Author author)
    {
        name_ = author.name_;
        surname_ = author.surname_;
    }

    @Override
    public String toString()
    {
        return name_ + surname_;
    }

    public void print()
    {
        System.out.print(this);
    }

    private <T> boolean containsObject(List<T> list, T object)
    {
        for (T iterator : list)
        {
            if (object.equals(iterator))
                return true;
        }

        return false;
    }

    private <T> boolean checkCollectionSubsetOfAnother(List<T> collection_1, List<T> collection_2)
    {
        for (T obj : collection_1)
        {
            if (!containsObject(collection_2, obj))
            {
                return false;
            }
        }

        return true;
    }

    // Compare the contents of two collections
    private <T> boolean compareList(List<T> collection_1, List<T> collection_2)
    {
        return collection_1.size() == collection_2.size() && checkCollectionSubsetOfAnother(collection_1, collection_2)
                && checkCollectionSubsetOfAnother(collection_2, collection_1);
    }

    @Override
    public boolean equals(Object author)
    {
        if (author == this)
            return true;

        if (!(author instanceof Author))
            return false;

        return surname_.equalsIgnoreCase(((Author)author).surname_) && name_.equalsIgnoreCase(((Author)author).name_);
    }

}

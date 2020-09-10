import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Category {
    private String categoryName;
    private static HashSet<Category> categorySet = new HashSet<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public static void showCategory() {
        System.out.println("Categories:");
        categorySet.stream().forEach(System.out::println);
    }

    public static boolean addCategory(Category categoryToAdd) {
        boolean ok = false;

        if(categorySet.add(categoryToAdd)) {
            ok = true;
        }

        return ok;
    }

    @Override
    public String toString() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }
}

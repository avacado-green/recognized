package service;

import model.FamilyTree;

import java.util.Comparator;

public class FamilyTreeService<T> {
    private FamilyTree<T> familyTree;

    public FamilyTreeService(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByName(Comparator<T> comparator) {
        familyTree.getMembers().sort(comparator);
    }

    public void sortByBirthDate(Comparator<T> comparator) {
        familyTree.getMembers().sort(comparator);
    }
}


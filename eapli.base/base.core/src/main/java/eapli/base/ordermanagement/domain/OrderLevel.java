package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.Immutable;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class OrderLevel {

    public enum Level {
        DELIVERED,
        DISPATCHED,
        ASSIGNED,
        UNASSIGNED
    }

    private Level level;

    protected OrderLevel() {
    }

    public OrderLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    private void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Level is: "+level;
    }
}

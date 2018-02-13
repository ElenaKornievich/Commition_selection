package com.kornievich.selectionCommition.entity;

import java.io.Serializable;
import java.util.Objects;

public class CTPoint implements Serializable, Cloneable{
    private int entrantId;
    private int subjectId;
    private int scope;

    @Override
    public String toString() {
        return "CTPoint{" +
                "entrantId=" + entrantId +
                ", subjectId=" + subjectId +
                ", scope=" + scope +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CTPoint ctPoint = (CTPoint) o;
        return entrantId == ctPoint.entrantId &&
                subjectId == ctPoint.subjectId &&
                scope == ctPoint.scope;
    }

    @Override
    public int hashCode() {

        return Objects.hash(entrantId, subjectId, scope);
    }

    public CTPoint(int entrantId, int subjectId, int scope) {
        this.entrantId = entrantId;
        this.subjectId = subjectId;
        this.scope = scope;
    }

    public int getEntrantId() {
        return entrantId;
    }

    public void setEntrantId(int entrantId) {
        this.entrantId = entrantId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
}

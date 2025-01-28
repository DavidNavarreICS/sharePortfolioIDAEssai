/*
* Copyright 2025 David Navarre <David.Navarre@irit.fr>.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
*      http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package fr.utc.miage.shares;

import java.util.Objects;

/**
 *
 * @author perussel
 */
public abstract class Action {
    /**
     * Label attribute.
     */
    private final String libelle;

    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Builds an action based on a label.
     * 
     * @param libelle the label of the share
     */
    protected Action(final String libelle) {
        this.libelle = libelle;
    }

    /**
     * Provides the value ofthe share for a given day.
     * 
     * @param aDay the day
     * @return the value of this share for this day
     */
    public abstract float valeur(Jour aDay);

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.libelle);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Action other = (Action) obj;
        return (Objects.equals(this.libelle, other.libelle));
    }

    @Override
    public String toString() {
        return this.getLibelle();
    }
}

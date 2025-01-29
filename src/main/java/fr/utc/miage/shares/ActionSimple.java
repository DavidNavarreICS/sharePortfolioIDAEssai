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

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a share.
 * 
 * @author David Navarre &lt;David.Navarre@irit.fr&gt;
 */
public class ActionSimple extends AbstractAction {

    /**
     * Storage of the value of the share for each day.
     */
    private final Map<Jour, Cours> mapCours;

    /**
     * Builds an ActionSimple from a label.
     * 
     * @param libelle the label of the share.
     */
    public ActionSimple(final String libelle) {
        super(libelle);
        this.mapCours = new HashMap<>();
    }

    /**
     * Registers the value of the share for a given day.
     * 
     * @param j the day of the change
     * @param v the value of the share for this day
     */
    public void enrgCours(final Jour j, final float v) {
        if (!this.mapCours.containsKey(j)) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }

    @Override
    public float valeur(final Jour j) {
        if (this.mapCours.containsKey(j) == true)
            return this.mapCours.get(j).getValeur();
        else
            return 0; // definition d'une constante possible
    }

    /**
     * Utility that represents a couple day/value.
     */
    private class Cours {
        /**
         * The day attribute.
         */
        private final Jour jour;
        /**
         * The value attribute.
         */
        private final float valeur;

        /**
         * Builds a Cours object.
         * 
         * @param jour   the day
         * @param valeur the value
         */
        public Cours(final Jour jour, final float valeur) {
            this.jour = jour;
            this.valeur = valeur;
        }

        /**
         * Read access to the value.
         * 
         * @return the value
         */
        public float getValeur() {
            return valeur;
        }

        /**
         * Read access to the day.
         * 
         * @return the day
         */
        public Jour getJour() {
            return jour;
        }

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }
}

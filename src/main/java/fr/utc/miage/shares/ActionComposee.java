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
 * This class represents a set of shares that behave as one share.
 * 
 * @author David Navarre &lt;David.Navarre@irit.fr&gt;
 */
public class ActionComposee extends AbstractAction {
    // attribut lien
    private final Map<ActionSimple, Float> mapPanier;

    /**
     * Builds an ActionComposee from a single label.
     * 
     * @param libelle label of the auction
     */
    public ActionComposee(final String libelle) {
        super(libelle);
        this.mapPanier = new HashMap<>();
    }

    /**
     * Registers a new share.
     * 
     * @param as          an ActionSimple object
     * @param pourcentage the quantity of this share
     */
    public void enrgComposition(final ActionSimple as, final float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

    @Override
    public float valeur(final Jour j) {
        float valeur;

        valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }

        return valeur;
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }
}

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
 * This class represents a portfolio of shares.
 * 
 * @author David Navarre &lt;David.Navarre@irit.fr&gt;
 */
public class Portefeuille {
    /**
     * The collection of shares in this portfolio with their quantity.
     */
    private final Map<AbstractAction, Integer> mapLignes;

    /**
     * Builds a protfolio.
     */
    public Portefeuille() {
        this.mapLignes = new HashMap<>();
    }

    /**
     * Stores the bought share.
     * 
     * @param a the share
     * @param q the quantity of this share
     */
    public void acheter(final AbstractAction a, final int q) {
        if (this.mapLignes.containsKey(a) == false) {
            this.mapLignes.put(a, q);
        } else {
            this.mapLignes.put(a, this.mapLignes.get(a) + q);
        }
    }

    /**
     * Sells a quantity of a share.
     * 
     * @param a the share
     * @param q the quantity
     */
    public void vendre(final AbstractAction a, final int q) {
        if (this.mapLignes.containsKey(a) == true) {
            if (this.mapLignes.get(a) > q) {
                this.mapLignes.put(a, this.mapLignes.get(a) - q);
            } else if (this.mapLignes.get(a) == q) {
                this.mapLignes.remove(a);
            }
        }
    }

    @Override
    public String toString() {
        return this.mapLignes.toString();
    }

    /**
     * Provides the value of the protfolio.
     * 
     * @param j the day
     * @return the value
     */
    public float valeur(final Jour j) {
        float total = 0;
        for (Map.Entry<AbstractAction, Integer> iterable_element : mapLignes.entrySet()) {
            total = total + (iterable_element.getValue() * iterable_element.getKey().valeur(j));
        }
        return total;
    }
}

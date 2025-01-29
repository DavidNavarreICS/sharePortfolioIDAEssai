/*
 * Copyright 2024 David Navarre &lt;David.Navarre at irit.fr&gt;.
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.utc.miage.shares.AbstractAction;
import fr.utc.miage.shares.Jour;

/**
 *
 * @author David Navarre &lt;David.Navarre at irit.fr&gt;
 */
class ActionTest {
    private static final String DEFAULT_LABEL = "ABC";

    @Test
    void testGetLibelle() {
        // ARRANGE
        final AbstractAction action = new ActionImpl(DEFAULT_LABEL);

        // ACTIONS
        final String currentLabel = action.getLibelle();

        // ASSERTIONS
        Assertions.assertEquals(DEFAULT_LABEL, currentLabel,
                "Label should be the one used for the creation of the object");
    }

    public class ActionImpl extends AbstractAction {

        public ActionImpl(final String label) {
            super(label);
        }

        public float valeur(Jour j) {
            return 0.0F;
        }
    }

}

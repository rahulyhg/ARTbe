package com.kampherbeek.art.domain;

/**
 * Enum for HouseSystems. The value for seId corresponds with the indexes as used by the Swiss Ephemeris.
 * IF the system is not supported by the SE the value for seId = '#'.
 * internalId is the value used internally in ART.
 */
public enum HouseSystems {

        NONE('!', 0, 0,"housesystems.none"),
        PLACIDUS('P', 1, 12, "housesystems.placidus"),
        KOCH('K',2, 12, "housesystems.koch"),
        PORPHYRI('O',3, 12, "housesystems.porphyri"),
        REGIOMONTANUS('R',4, 12, "housesystems.regiomontanus"),
        CAMPANUS('C',5, 12, "housesystems.campanus"),
        EQUAL_ASC('A',6, 12, "housesystems.equal_asc"),           // SE also supports 'E'.
        VEHLOW('V',7, 12, "housesystems.vehlow"),
        WHOLE_SIGN('W',8, 12, "housesystems.whole_sign"),
        AXIAL_ROTATION('X',9, 12, "housesystems.axial_rotation"),
        HORIZONTAL('H',10, 12, "housesystems.horizontal"),
        TOPOCENTRIC('T',11, 12, "housesystems.topocentric"),
        ALCABITIUS('B',12, 12, "housesystems.alcabitius"),
        MORIN('M',13, 12, "housesystems.morin"),
        KRUSINSKI('K',14, 12, "housesystems.krusinski"),
        GAUQUELIN('G',15, 36, "housesystems.gauquelin"),
        APC('Y',16, 12, "housesystems.apc");


        private final char seId;
        private final int internalId;
        private final int nrOfCusps;
        private final String rbKey;

        HouseSystems(char seId, int internalId, int nrOfCusps, String rbKey) {
            this.seId = seId;
            this.internalId = internalId;
            this.nrOfCusps = nrOfCusps;
            this.rbKey = rbKey;
        }

        /**
         * Getter for seId, the value as used by the Swiss Ephemeris.
         * If a system is not supported by the SE, this value will be '#'.
         * @return Value for seId, the internalId as used by the Swiss Ephemeris, or '#' if SE does not handle the system.
         */
        public char getSeId() {
            return seId;
        }

        public int getInternalId() {
            return internalId;
        }

        public int getNrOfCusps() {
                return nrOfCusps;
        }

        /**
         * Getter for rbKey
         * @return key to access Resource Bundle.
         */
        public String getRbKey() {
                return rbKey;
        }
}

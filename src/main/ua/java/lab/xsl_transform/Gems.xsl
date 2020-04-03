<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">

        <gems>
            <xsl:for-each select="gems/gem">
                <xsl:element name="origin">
                    <xsl:attribute name="name">
                        <xsl:value-of select="origin"/>
                    </xsl:attribute>
                    <gem name="{@name}"/>
                    <preciousness>
                        <xsl:value-of select="preciousness"/>
                    </preciousness>
                    <visual>
                        <color>
                            <xsl:value-of select="visual/color"/>
                        </color>
                        <clarity>
                            <xsl:value-of select="visual/clarity"/>
                        </clarity>
                        <cut>
                            <xsl:value-of select="visual/cut"/>
                        </cut>
                    </visual>
                    <carat>
                        <xsl:value-of select="carat"/>
                    </carat>
                </xsl:element>
            </xsl:for-each>
        </gems>
    </xsl:template>
</xsl:stylesheet>
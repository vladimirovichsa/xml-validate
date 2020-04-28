<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes" xslt:indent-amount="4" xmlns:xslt="http://xml.apache.org/xslt"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="@* | node()">
        <xsl:copy>
            <xsl:apply-templates select="@* | node()"/>
        </xsl:copy>
    </xsl:template>


    <!--http://xerces.apache.org/xerces-j/schema.html-->
    <!--Due to the way in which the parser constructs content models for elements with complex content,-->
    <!--specifying large values for the minOccurs or maxOccurs attributes may cause the parser to throw-->
    <!--a StackOverflowError. Large values for minOccurs should be avoided, and unbounded should be used instead-->
    <!--of a large value for maxOccurs.-->

    <xsl:template match="//*[@maxOccurs>100]/@maxOccurs">
        <xsl:attribute name="maxOccurs">unbounded</xsl:attribute>
    </xsl:template>

</xsl:stylesheet>

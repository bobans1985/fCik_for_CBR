package ru.bobans.map_obj;//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.20 at 11:55:09 AM MSK 
//


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "\u0437\u0430\u043f\u0440\u043e\u0441",
    "\u0438\u043d\u0444\u041e\u0440\u0433",
    "\u043f\u0435\u0440\u0441\u043e\u043d\u0430"
})
@XmlRootElement(name = "\u0424\u0430\u0439\u043b")
public class Файл {

    @XmlElement(name = "\u0417\u0430\u043f\u0440\u043e\u0441", required = true)
    protected Файл.Запрос запрос;
    @XmlElement(name = "\u0418\u043d\u0444\u041e\u0440\u0433")
    protected Файл.ИнфОрг инфОрг;
    @XmlElement(name = "\u041f\u0435\u0440\u0441\u043e\u043d\u0430", required = true)
    protected List<Файл.Персона> персона;
    @XmlAttribute(name = "\u0412\u0435\u0440\u0441\u0424\u043e\u0440\u043c", required = true)
    protected String версФорм;
    @XmlAttribute(name = "\u0422\u0438\u043f\u0418\u043d\u0444", required = true)
    protected String типИнф;
    @XmlAttribute(name = "\u0412\u0435\u0440\u0441\u041f\u0440\u043e\u0433", required = true)
    protected String версПрог;
    @XmlAttribute(name = "\u0418\u0434\u0424\u0430\u0439\u043b", required = true)
    protected String идФайл;


    public Файл.Запрос getЗапрос() {
        return запрос;
    }

    public void setПерсона(List<Персона> персона) {
        this.персона = персона;
    }

    public void setЗапрос(Файл.Запрос value) {
        this.запрос = value;
    }


    public Файл.ИнфОрг getИнфОрг() {
        return инфОрг;
    }


    public void setИнфОрг(Файл.ИнфОрг value) {
        this.инфОрг = value;
    }


    public List<Файл.Персона> getПерсона() {
        if (персона == null) {
            персона = new ArrayList<Файл.Персона>();
        }
        return this.персона;
    }


    public String getВерсФорм() {
        return версФорм;
    }


    public void setВерсФорм(String value) {
        this.версФорм = value;
    }


    public String getТипИнф() {
        return типИнф;
    }


    public void setТипИнф(String value) {
        this.типИнф = value;
    }


    public String getВерсПрог() {
        return версПрог;
    }


    public void setВерсПрог(String value) {
        this.версПрог = value;
    }


    public String getИдФайл() {
        return идФайл;
    }


    public void setИдФайл(String value) {
        this.идФайл = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Запрос {

        @XmlAttribute(name = "\u0418\u0434", required = true)
        protected String ид;
        @XmlAttribute(name = "\u0414\u0430\u0442\u0430", required = true)
        protected String дата;


        public String getИд() {
            return ид;
        }


        public void setИд(String value) {
            this.ид = value;
        }


        public String getДата() {
            return дата;
        }


        public void setДата(String value) {
            this.дата = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ИнфОрг {

        @XmlAttribute(name = "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", required = true)
        protected String название;
        @XmlAttribute(name = "\u0410\u0434\u0440\u0435\u0441", required = true)
        protected String адрес;
        @XmlAttribute(name = "\u0418\u041d\u041d", required = true)
        protected String инн;
        @XmlAttribute(name = "\u041e\u0413\u0420\u041d", required = true)
        protected String огрн;
        @XmlAttribute(name = "\u0424\u0418\u041e", required = true)
        protected String фио;
        @XmlAttribute(name = "\u0422\u0435\u043b\u0435\u0444\u043e\u043d", required = true)
        protected String телефон;
        @XmlAttribute(name = "\u042d\u043b\u041f\u043e\u0447\u0442\u0430", required = true)
        protected String элПочта;


        public String getНазвание() {
            return название;
        }


        public void setНазвание(String value) {
            this.название = value;
        }


        public String getАдрес() {
            return адрес;
        }


        public void setАдрес(String value) {
            this.адрес = value;
        }


        public String getИНН() {
            return инн;
        }


        public void setИНН(String value) {
            this.инн = value;
        }


        public String getОГРН() {
            return огрн;
        }


        public void setОГРН(String value) {
            this.огрн = value;
        }


        public String getФИО() {
            return фио;
        }


        public void setФИО(String value) {
            this.фио = value;
        }


        public String getТелефон() {
            return телефон;
        }


        public void setТелефон(String value) {
            this.телефон = value;
        }


        public String getЭлПочта() {
            return элПочта;
        }


        public void setЭлПочта(String value) {
            this.элПочта = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "\u043f\u0435\u0440\u0441\u0418\u043d\u0444\u043e",
        "\u0446\u0435\u043d\u043d\u044b\u0435\u0411\u0443\u043c\u0430\u0433\u0438",
        "\u0441\u0447\u0435\u0442\u0430",
        "\u0441\u043b\u0443\u0436\u0418\u043d\u0444\u043e"
    })
    public static class Персона {

        @XmlElement(name = "\u041f\u0435\u0440\u0441\u0418\u043d\u0444\u043e", required = true)
        protected Файл.Персона.ПерсИнфо персИнфо;
        @XmlElement(name = "\u0426\u0435\u043d\u043d\u044b\u0435\u0411\u0443\u043c\u0430\u0433\u0438")
        protected List<Файл.Персона.ЦенныеБумаги> ценныеБумаги;
        @XmlElement(name = "\u0421\u0447\u0435\u0442\u0430")
        protected List<Файл.Персона.Счета> счета;
        @XmlElement(name = "\u0421\u043b\u0443\u0436\u0418\u043d\u0444\u043e", required = true)
        protected Файл.Персона.СлужИнфо служИнфо;
        @XmlAttribute(name = "\u0418\u0434", required = true)
        protected String ид;


        public Файл.Персона.ПерсИнфо getПерсИнфо() {
            return персИнфо;
        }


        public void setПерсИнфо(Файл.Персона.ПерсИнфо value) {
            this.персИнфо = value;
        }

        public List<Файл.Персона.ЦенныеБумаги> getЦенныеБумаги() {
            if (ценныеБумаги == null) {
                ценныеБумаги = new ArrayList<Файл.Персона.ЦенныеБумаги>();
            }
            return this.ценныеБумаги;
        }


        public List<Файл.Персона.Счета> getСчета() {
            if (счета == null) {
                счета = new ArrayList<Файл.Персона.Счета>();
            }
            return this.счета;
        }

        public void setСчета(List<Счета> счета) {
            this.счета = счета;
        }

        public Файл.Персона.СлужИнфо getСлужИнфо() {
            return служИнфо;
        }


        public void setСлужИнфо(Файл.Персона.СлужИнфо value) {
            this.служИнфо = value;
        }


        public String getИд() {
            return ид;
        }


        public void setИд(String value) {
            this.ид = value;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "\u0444\u0438\u043e\u0434",
            "\u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442",
            "\u0430\u0434\u0440\u0435\u0441"
        })
        public static class ПерсИнфо {

            @XmlElement(name = "\u0424\u0418\u041e\u0414", required = true)
            protected Файл.Персона.ПерсИнфо.ФИОД фиод;
            @XmlElement(name = "\u0414\u043e\u043a\u0443\u043c\u0435\u043d\u0442", required = true)
            protected Файл.Персона.ПерсИнфо.Документ документ;
            @XmlElement(name = "\u0410\u0434\u0440\u0435\u0441", required = true)
            protected Файл.Персона.ПерсИнфо.Адрес адрес;


            public Файл.Персона.ПерсИнфо.ФИОД getФИОД() {
                return фиод;
            }


            public void setФИОД(Файл.Персона.ПерсИнфо.ФИОД value) {
                this.фиод = value;
            }


            public Файл.Персона.ПерсИнфо.Документ getДокумент() {
                return документ;
            }


            public void setДокумент(Файл.Персона.ПерсИнфо.Документ value) {
                this.документ = value;
            }


            public Файл.Персона.ПерсИнфо.Адрес getАдрес() {
                return адрес;
            }


            public void setАдрес(Файл.Персона.ПерсИнфо.Адрес value) {
                this.адрес = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Адрес {

                @XmlAttribute(name = "\u041a\u043e\u0434\u0421\u0443\u0431\u044a\u0435\u043a\u0442\u0430", required = true)
                protected String кодСубъекта;
                @XmlAttribute(name = "\u041d\u0435\u043a\u043e\u043d\u0444\u0410\u0434\u0440\u0435\u0441", required = true)
                protected String неконфАдрес;
                @XmlAttribute(name = "\u041a\u043e\u043d\u0444\u0410\u0434\u0440\u0435\u0441", required = true)
                protected String конфАдрес;
                @XmlAttribute(name = "\u041c\u0435\u0441\u0442\u043e\u0420\u043e\u0436\u0434\u0435\u043d\u0438\u044f", required = true)
                protected String местоРождения;


                public String getКодСубъекта() {
                    return кодСубъекта;
                }


                public void setКодСубъекта(String value) {
                    this.кодСубъекта = value;
                }


                public String getНеконфАдрес() {
                    return неконфАдрес;
                }


                public void setНеконфАдрес(String value) {
                    this.неконфАдрес = value;
                }


                public String getКонфАдрес() {
                    return конфАдрес;
                }


                public void setКонфАдрес(String value) {
                    this.конфАдрес = value;
                }


                public String getМестоРождения() {
                    return местоРождения;
                }


                public void setМестоРождения(String value) {
                    this.местоРождения = value;
                }

            }



            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Документ {

                @XmlAttribute(name = "\u041a\u043e\u0434\u0412\u0438\u0434\u0414\u043e\u043a", required = true)
                protected String кодВидДок;
                @XmlAttribute(name = "\u0421\u0435\u0440\u0438\u044f", required = true)
                protected String серия;
                @XmlAttribute(name = "\u041d\u043e\u043c\u0435\u0440", required = true)
                protected String номер;


                public String getКодВидДок() {
                    return кодВидДок;
                }


                public void setКодВидДок(String value) {
                    this.кодВидДок = value;
                }


                public String getСерия() {
                    return серия;
                }


                public void setСерия(String value) {
                    this.серия = value;
                }


                public String getНомер() {
                    return номер;
                }


                public void setНомер(String value) {
                    this.номер = value;
                }

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ФИОД {

                @XmlAttribute(name = "\u0424\u0430\u043c\u0438\u043b\u0438\u044f", required = true)
                protected String фамилия;
                @XmlAttribute(name = "\u0418\u043c\u044f", required = true)
                protected String имя;
                @XmlAttribute(name = "\u041e\u0442\u0447\u0435\u0441\u0442\u0432\u043e", required = true)
                protected String отчество;
                @XmlAttribute(name = "\u0414\u0430\u0442\u0430\u0420\u043e\u0436\u0434")
                protected String датаРожд;


                public String getФамилия() {
                    return фамилия;
                }


                public void setФамилия(String value) {
                    this.фамилия = value;
                }


                public String getИмя() {
                    return имя;
                }


                public void setИмя(String value) {
                    this.имя = value;
                }


                public String getОтчество() {
                    return отчество;
                }


                public void setОтчество(String value) {
                    this.отчество = value;
                }


                public String getДатаРожд() {
                    return датаРожд;
                }


                public void setДатаРожд(String value) {
                    this.датаРожд = value;
                }

            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "\u0438\u0434\u0418\u043d\u0444\u043e",
            "\u043d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435"
        })
        public static class СлужИнфо {

            @XmlElement(name = "\u0418\u0414\u0418\u043d\u0444\u043e", required = true)
            protected Файл.Персона.СлужИнфо.ИДИнфо идИнфо;
            @XmlElement(name = "\u041d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435", required = true)
            protected Файл.Персона.СлужИнфо.Наименование наименование;
            @XmlAttribute(name = "\u0412\u0420\u041d\u041a\u0430\u043d\u0434", required = true)
            protected BigInteger врнКанд;


            public Файл.Персона.СлужИнфо.ИДИнфо getИДИнфо() {
                return идИнфо;
            }


            public void setИДИнфо(Файл.Персона.СлужИнфо.ИДИнфо value) {
                this.идИнфо = value;
            }


            public Файл.Персона.СлужИнфо.Наименование getНаименование() {
                return наименование;
            }


            public void setНаименование(Файл.Персона.СлужИнфо.Наименование value) {
                this.наименование = value;
            }


            public BigInteger getВРНКанд() {
                return врнКанд;
            }


            public void setВРНКанд(BigInteger value) {
                this.врнКанд = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ИДИнфо {

                @XmlAttribute(name = "\u041a\u043e\u0434\u0421\u0443\u0431\u044a\u0435\u043a\u0442\u0430", required = true)
                protected String кодСубъекта;
                @XmlAttribute(name = "\u041a\u0430\u043c\u043f\u0430\u043d\u0438\u044f", required = true)
                protected BigInteger кампания;
                @XmlAttribute(name = "\u0421\u0438\u0441\u0442\u0435\u043c\u0430", required = true)
                @XmlSchemaType(name = "unsignedByte")
                protected short система;


                public String getКодСубъекта() {
                    return кодСубъекта;
                }


                public void setКодСубъекта(String value) {
                    this.кодСубъекта = value;
                }

                public BigInteger getКампания() {
                    return кампания;
                }

                public void setКампания(BigInteger value) {
                    this.кампания = value;
                }

                public short getСистема() {
                    return система;
                }

                public void setСистема(short value) {
                    this.система = value;
                }

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Наименование {

                @XmlAttribute(name = "\u0412\u044b\u0431\u043e\u0440\u044b", required = true)
                protected String выборы;
                @XmlAttribute(name = "\u0421\u0443\u0431\u044a\u0435\u043a\u0442", required = true)
                protected String субъект;
                @XmlAttribute(name = "\u0414\u0430\u0442\u0430\u0421\u0432\u0435\u0434", required = true)
                protected String датаСвед;

                public String getВыборы() {
                    return выборы;
                }

                public void setВыборы(String value) {
                    this.выборы = value;
                }

                public String getСубъект() {
                    return субъект;
                }

                public void setСубъект(String value) {
                    this.субъект = value;
                }

                public String getДатаСвед() {
                    return датаСвед;
                }

                public void setДатаСвед(String value) {
                    this.датаСвед = value;
                }

            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "\u0441\u0447\u0435\u0442",
            "\u043a\u0440\u0435\u0434\u0438\u0442\u041e\u0440\u0433"
        })
        public static class Счета {

            @XmlElement(name = "\u0421\u0447\u0435\u0442", required = true)
            protected Файл.Персона.Счета.Счет счет;
            @XmlElement(name = "\u041a\u0440\u0435\u0434\u0438\u0442\u041e\u0440\u0433", required = true)
            protected Файл.Персона.Счета.КредитОрг кредитОрг;
            @XmlAttribute(name = "\u0418\u0434\u0421\u0447\u0435\u0442\u0430", required = true)
            protected String идСчета;


            public Файл.Персона.Счета.Счет getСчет() {
                return счет;
            }

            public void setСчет(Файл.Персона.Счета.Счет value) {
                this.счет = value;
            }

            public Файл.Персона.Счета.КредитОрг getКредитОрг() {
                return кредитОрг;
            }

            public void setКредитОрг(Файл.Персона.Счета.КредитОрг value) {
                this.кредитОрг = value;
            }

            public String getИдСчета() {
                return идСчета;
            }

            public void setИдСчета(String value) {
                this.идСчета = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class КредитОрг {

                @XmlAttribute(name = "\u041d\u0430\u0438\u043c\u041a\u0440\u0435\u0434\u0438\u0442", required = true)
                protected String наимКредит;
                @XmlAttribute(name = "\u041a\u043e\u0434\u0421\u0443\u0431\u041a\u0440\u0435\u0434", required = true)
                protected String кодСубКред;
                @XmlAttribute(name = "\u041d\u0435\u043a\u043e\u043d\u0444\u0410\u0434\u0440\u041a\u0440\u0435\u0434", required = true)
                protected String неконфАдрКред;
                @XmlAttribute(name = "\u041a\u043e\u043d\u0444\u0410\u0434\u0440\u041a\u0440\u0435\u0434", required = true)
                protected String конфАдрКред;

                public String getНаимКредит() {
                    return наимКредит;
                }

                public void setНаимКредит(String value) {
                    this.наимКредит = value;
                }

                public String getКодСубКред() {
                    return кодСубКред;
                }

                public void setКодСубКред(String value) {
                    this.кодСубКред = value;
                }

                public String getНеконфАдрКред() {
                    return неконфАдрКред;
                }

                public void setНеконфАдрКред(String value) {
                    this.неконфАдрКред = value;
                }

                public String getКонфАдрКред() {
                    return конфАдрКред;
                }

                public void setКонфАдрКред(String value) {
                    this.конфАдрКред = value;
                }

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Счет {

                @XmlAttribute(name = "\u0412\u0438\u0434\u0421\u0447\u0435\u0442\u0430", required = true)
                protected String видСчета;
                @XmlAttribute(name = "\u041d\u043e\u043c\u0435\u0440\u0421\u0447\u0435\u0442\u0430", required = true)
                protected String номерСчета;
                @XmlAttribute(name = "\u041e\u0441\u0442\u0430\u0442\u043e\u043a", required = true)
                protected BigDecimal остаток;

                public String getВидСчета() {
                    return видСчета;
                }

                public void setВидСчета(String value) {
                    this.видСчета = value;
                }

                public String getНомерСчета() {
                    return номерСчета;
                }

                public void setНомерСчета(String value) {
                    this.номерСчета = value;
                }

                public BigDecimal getОстаток() {
                    return остаток;
                }

                public void setОстаток(BigDecimal value) {
                    this.остаток = value;
                }

            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "\u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044f",
            "\u0431\u0443\u043c\u0430\u0433\u0430"
        })
        public static class ЦенныеБумаги {

            @XmlElement(name = "\u041e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044f", required = true)
            protected Файл.Персона.ЦенныеБумаги.Организация организация;
            @XmlElement(name = "\u0411\u0443\u043c\u0430\u0433\u0430", required = true)
            protected Файл.Персона.ЦенныеБумаги.Бумага бумага;
            @XmlAttribute(name = "\u0418\u0434\u0411\u0443\u043c\u0430\u0433\u0438", required = true)
            protected String идБумаги;

            public Файл.Персона.ЦенныеБумаги.Организация getОрганизация() {
                return организация;
            }

            public void setОрганизация(Файл.Персона.ЦенныеБумаги.Организация value) {
                this.организация = value;
            }

            public Файл.Персона.ЦенныеБумаги.Бумага getБумага() {
                return бумага;
            }

            public void setБумага(Файл.Персона.ЦенныеБумаги.Бумага value) {
                this.бумага = value;
            }

            public String getИдБумаги() {
                return идБумаги;
            }

            public void setИдБумаги(String value) {
                this.идБумаги = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Бумага {

                @XmlAttribute(name = "\u041a\u043e\u0434\u0412\u0438\u0434\u0411\u0443\u043c", required = true)
                protected String кодВидБум;
                @XmlAttribute(name = "\u041a\u043e\u0434\u041a\u0430\u0442\u0435\u0433", required = true)
                protected String кодКатег;
                @XmlAttribute(name = "\u041a\u043e\u043b\u0432\u043e", required = true)
                protected String колво;
                @XmlAttribute(name = "\u041a\u043e\u043b\u0432\u043e\u0427\u0438\u0441\u043b", required = true)
                protected String колвоЧисл;
                @XmlAttribute(name = "\u041a\u043e\u043b\u0432\u043e\u0417\u043d\u0430\u043c", required = true)
                protected String колвоЗнам;
                @XmlAttribute(name = "\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c", required = true)
                protected BigDecimal стоимость;

                public String getКодВидБум() {
                    return кодВидБум;
                }

                public void setКодВидБум(String value) {
                    this.кодВидБум = value;
                }

                public String getКодКатег() {
                    return кодКатег;
                }

                public void setКодКатег(String value) {
                    this.кодКатег = value;
                }

                public String getКолво() {
                    return колво;
                }

                public void setКолво(String value) {
                    this.колво = value;
                }

                public String getКолвоЧисл() {
                    return колвоЧисл;
                }

                public void setКолвоЧисл(String value) {
                    this.колвоЧисл = value;
                }

                public String getКолвоЗнам() {
                    return колвоЗнам;
                }

                public void setКолвоЗнам(String value) {
                    this.колвоЗнам = value;
                }

                public BigDecimal getСтоимость() {
                    return стоимость;
                }

                public void setСтоимость(BigDecimal value) {
                    this.стоимость = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Организация {

                @XmlAttribute(name = "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", required = true)
                protected String название;
                @XmlAttribute(name = "\u0418\u041d\u041d\u041e\u0440\u0433", required = true)
                protected String иннОрг;
                @XmlAttribute(name = "\u041f\u0418\u0424", required = true)
                protected String пиф;
                @XmlAttribute(name = "\u0421\u0442\u0430\u0442\u0443\u0441", required = true)
                protected String статус;
                @XmlAttribute(name = "\u0414\u043e\u043b\u044f\u041f\u0440\u043e\u0446\u0435\u043d\u0442", required = true)
                protected String доляПроцент;
                @XmlAttribute(name = "\u0414\u043e\u043b\u044f\u0427\u0438\u0441\u043b\u0438\u0442\u0435\u043b\u044c", required = true)
                protected String доляЧислитель;
                @XmlAttribute(name = "\u0414\u043e\u043b\u044f\u0417\u043d\u0430\u043c\u0435\u043d\u0430\u0442\u0435\u043b\u044c", required = true)
                protected String доляЗнаменатель;
                @XmlAttribute(name = "\u041a\u043e\u0434\u0421\u0443\u0431\u041e\u0440\u0433", required = true)
                protected String кодСубОрг;
                @XmlAttribute(name = "\u041d\u0435\u043a\u043e\u043d\u0444\u0410\u0434\u0440\u041e\u0440\u0433", required = true)
                protected String неконфАдрОрг;
                @XmlAttribute(name = "\u041a\u043e\u043d\u0444\u0410\u0434\u0440\u041e\u0440\u0433", required = true)
                protected String конфАдрОрг;

                public String getНазвание() {
                    return название;
                }

                public void setНазвание(String value) {
                    this.название = value;
                }

                public String getИННОрг() {
                    return иннОрг;
                }

                public void setИННОрг(String value) {
                    this.иннОрг = value;
                }

                public String getПИФ() {
                    return пиф;
                }

                public void setПИФ(String value) {
                    this.пиф = value;
                }

                public String getСтатус() {
                    return статус;
                }

                public void setСтатус(String value) {
                    this.статус = value;
                }

                public String getДоляПроцент() {
                    return доляПроцент;
                }

                public void setДоляПроцент(String value) {
                    this.доляПроцент = value;
                }

                public String getДоляЧислитель() {
                    return доляЧислитель;
                }

                public void setДоляЧислитель(String value) {
                    this.доляЧислитель = value;
                }

                public String getДоляЗнаменатель() {
                    return доляЗнаменатель;
                }

                public void setДоляЗнаменатель(String value) {
                    this.доляЗнаменатель = value;
                }

                public String getКодСубОрг() {
                    return кодСубОрг;
                }

                public void setКодСубОрг(String value) {
                    this.кодСубОрг = value;
                }

                public String getНеконфАдрОрг() {
                    return неконфАдрОрг;
                }

                public void setНеконфАдрОрг(String value) {
                    this.неконфАдрОрг = value;
                }

                public String getКонфАдрОрг() {
                    return конфАдрОрг;
                }

                public void setКонфАдрОрг(String value) {
                    this.конфАдрОрг = value;
                }

            }

        }

    }

}

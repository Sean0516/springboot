package com.voicecyber.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVoiceidIsNull() {
            addCriterion("VOICEID is null");
            return (Criteria) this;
        }

        public Criteria andVoiceidIsNotNull() {
            addCriterion("VOICEID is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceidEqualTo(Integer value) {
            addCriterion("VOICEID =", value, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidNotEqualTo(Integer value) {
            addCriterion("VOICEID <>", value, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidGreaterThan(Integer value) {
            addCriterion("VOICEID >", value, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("VOICEID >=", value, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidLessThan(Integer value) {
            addCriterion("VOICEID <", value, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidLessThanOrEqualTo(Integer value) {
            addCriterion("VOICEID <=", value, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidIn(List<Integer> values) {
            addCriterion("VOICEID in", values, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidNotIn(List<Integer> values) {
            addCriterion("VOICEID not in", values, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidBetween(Integer value1, Integer value2) {
            addCriterion("VOICEID between", value1, value2, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceidNotBetween(Integer value1, Integer value2) {
            addCriterion("VOICEID not between", value1, value2, "voiceid");
            return (Criteria) this;
        }

        public Criteria andVoiceipIsNull() {
            addCriterion("VOICEIP is null");
            return (Criteria) this;
        }

        public Criteria andVoiceipIsNotNull() {
            addCriterion("VOICEIP is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceipEqualTo(String value) {
            addCriterion("VOICEIP =", value, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipNotEqualTo(String value) {
            addCriterion("VOICEIP <>", value, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipGreaterThan(String value) {
            addCriterion("VOICEIP >", value, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipGreaterThanOrEqualTo(String value) {
            addCriterion("VOICEIP >=", value, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipLessThan(String value) {
            addCriterion("VOICEIP <", value, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipLessThanOrEqualTo(String value) {
            addCriterion("VOICEIP <=", value, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipLike(String value) {
            addCriterion("VOICEIP like", value, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipNotLike(String value) {
            addCriterion("VOICEIP not like", value, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipIn(List<String> values) {
            addCriterion("VOICEIP in", values, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipNotIn(List<String> values) {
            addCriterion("VOICEIP not in", values, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipBetween(String value1, String value2) {
            addCriterion("VOICEIP between", value1, value2, "voiceip");
            return (Criteria) this;
        }

        public Criteria andVoiceipNotBetween(String value1, String value2) {
            addCriterion("VOICEIP not between", value1, value2, "voiceip");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNull() {
            addCriterion("ALARM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNotNull() {
            addCriterion("ALARM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeEqualTo(String value) {
            addCriterion("ALARM_TYPE =", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotEqualTo(String value) {
            addCriterion("ALARM_TYPE <>", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThan(String value) {
            addCriterion("ALARM_TYPE >", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ALARM_TYPE >=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThan(String value) {
            addCriterion("ALARM_TYPE <", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThanOrEqualTo(String value) {
            addCriterion("ALARM_TYPE <=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLike(String value) {
            addCriterion("ALARM_TYPE like", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotLike(String value) {
            addCriterion("ALARM_TYPE not like", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIn(List<String> values) {
            addCriterion("ALARM_TYPE in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotIn(List<String> values) {
            addCriterion("ALARM_TYPE not in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeBetween(String value1, String value2) {
            addCriterion("ALARM_TYPE between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotBetween(String value1, String value2) {
            addCriterion("ALARM_TYPE not between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeIsNull() {
            addCriterion("START_ALARM_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeIsNotNull() {
            addCriterion("START_ALARM_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeEqualTo(Date value) {
            addCriterion("START_ALARM_TIME =", value, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeNotEqualTo(Date value) {
            addCriterion("START_ALARM_TIME <>", value, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeGreaterThan(Date value) {
            addCriterion("START_ALARM_TIME >", value, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_ALARM_TIME >=", value, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeLessThan(Date value) {
            addCriterion("START_ALARM_TIME <", value, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_ALARM_TIME <=", value, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeIn(List<Date> values) {
            addCriterion("START_ALARM_TIME in", values, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeNotIn(List<Date> values) {
            addCriterion("START_ALARM_TIME not in", values, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeBetween(Date value1, Date value2) {
            addCriterion("START_ALARM_TIME between", value1, value2, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStartAlarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_ALARM_TIME not between", value1, value2, "startAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeIsNull() {
            addCriterion("STOP_ALARM_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeIsNotNull() {
            addCriterion("STOP_ALARM_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeEqualTo(Date value) {
            addCriterion("STOP_ALARM_TIME =", value, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeNotEqualTo(Date value) {
            addCriterion("STOP_ALARM_TIME <>", value, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeGreaterThan(Date value) {
            addCriterion("STOP_ALARM_TIME >", value, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STOP_ALARM_TIME >=", value, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeLessThan(Date value) {
            addCriterion("STOP_ALARM_TIME <", value, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("STOP_ALARM_TIME <=", value, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeIn(List<Date> values) {
            addCriterion("STOP_ALARM_TIME in", values, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeNotIn(List<Date> values) {
            addCriterion("STOP_ALARM_TIME not in", values, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeBetween(Date value1, Date value2) {
            addCriterion("STOP_ALARM_TIME between", value1, value2, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andStopAlarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("STOP_ALARM_TIME not between", value1, value2, "stopAlarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgIsNull() {
            addCriterion("ALARM_MSG is null");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgIsNotNull() {
            addCriterion("ALARM_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgEqualTo(String value) {
            addCriterion("ALARM_MSG =", value, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgNotEqualTo(String value) {
            addCriterion("ALARM_MSG <>", value, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgGreaterThan(String value) {
            addCriterion("ALARM_MSG >", value, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgGreaterThanOrEqualTo(String value) {
            addCriterion("ALARM_MSG >=", value, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgLessThan(String value) {
            addCriterion("ALARM_MSG <", value, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgLessThanOrEqualTo(String value) {
            addCriterion("ALARM_MSG <=", value, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgLike(String value) {
            addCriterion("ALARM_MSG like", value, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgNotLike(String value) {
            addCriterion("ALARM_MSG not like", value, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgIn(List<String> values) {
            addCriterion("ALARM_MSG in", values, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgNotIn(List<String> values) {
            addCriterion("ALARM_MSG not in", values, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgBetween(String value1, String value2) {
            addCriterion("ALARM_MSG between", value1, value2, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmMsgNotBetween(String value1, String value2) {
            addCriterion("ALARM_MSG not between", value1, value2, "alarmMsg");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIsNull() {
            addCriterion("ALARM_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIsNotNull() {
            addCriterion("ALARM_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelEqualTo(Integer value) {
            addCriterion("ALARM_LEVEL =", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotEqualTo(Integer value) {
            addCriterion("ALARM_LEVEL <>", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelGreaterThan(Integer value) {
            addCriterion("ALARM_LEVEL >", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("ALARM_LEVEL >=", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLessThan(Integer value) {
            addCriterion("ALARM_LEVEL <", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLessThanOrEqualTo(Integer value) {
            addCriterion("ALARM_LEVEL <=", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIn(List<Integer> values) {
            addCriterion("ALARM_LEVEL in", values, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotIn(List<Integer> values) {
            addCriterion("ALARM_LEVEL not in", values, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelBetween(Integer value1, Integer value2) {
            addCriterion("ALARM_LEVEL between", value1, value2, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("ALARM_LEVEL not between", value1, value2, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodIsNull() {
            addCriterion("ALARM_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodIsNotNull() {
            addCriterion("ALARM_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodEqualTo(String value) {
            addCriterion("ALARM_METHOD =", value, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodNotEqualTo(String value) {
            addCriterion("ALARM_METHOD <>", value, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodGreaterThan(String value) {
            addCriterion("ALARM_METHOD >", value, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodGreaterThanOrEqualTo(String value) {
            addCriterion("ALARM_METHOD >=", value, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodLessThan(String value) {
            addCriterion("ALARM_METHOD <", value, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodLessThanOrEqualTo(String value) {
            addCriterion("ALARM_METHOD <=", value, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodLike(String value) {
            addCriterion("ALARM_METHOD like", value, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodNotLike(String value) {
            addCriterion("ALARM_METHOD not like", value, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodIn(List<String> values) {
            addCriterion("ALARM_METHOD in", values, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodNotIn(List<String> values) {
            addCriterion("ALARM_METHOD not in", values, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodBetween(String value1, String value2) {
            addCriterion("ALARM_METHOD between", value1, value2, "alarmMethod");
            return (Criteria) this;
        }

        public Criteria andAlarmMethodNotBetween(String value1, String value2) {
            addCriterion("ALARM_METHOD not between", value1, value2, "alarmMethod");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
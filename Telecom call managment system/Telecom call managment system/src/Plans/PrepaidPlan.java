package Plans;
class PrepaidPlan implements Plan {
    @Override
    public double getPerMinuteRate() {
        return 0.5;
    }
}
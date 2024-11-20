export function formatNumber(num, decimals) {
    const r = new RegExp('\\d(?=(\\d{3})+' + (decimals > 0 ? '\\.' : '$') + ')', 'g');
    return num.toFixed(Math.max(0, Math.floor(decimals))).replace(r, '$&,');
}

export function animateCount(element, start, end, duration, decimals = 0) {
    const easingFunction = t => t * (2 - t); 
    const startTime = performance.now();

    function animate(currentTime) {
        const elapsedTime = currentTime - startTime;
        const progress = Math.min(elapsedTime / duration, 1);
        const easedProgress = easingFunction(progress);
        const currentValue = start + (end - start) * easedProgress;

        element.textContent = currentValue.toFixed(decimals);

        if (progress < 1) {
            requestAnimationFrame(animate);
        } else {
            element.textContent = `${end.toFixed(decimals)}+`;
        }
    }

    requestAnimationFrame(animate);
}


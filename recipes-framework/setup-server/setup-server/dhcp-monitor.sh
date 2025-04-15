#!/bin/bash

# Path to store the previous lease state
STATE_FILE="/var/run/dhcp-monitor-state"

# Get current number of leases
CURRENT_LEASES=$(cat /var/lib/misc/dnsmasq.leases | wc -l)

# Check if we have previous state
if [ -f "$STATE_FILE" ]; then
    PREVIOUS_LEASES=$(cat "$STATE_FILE")
else
    PREVIOUS_LEASES=0
fi

# Update state file
echo "$CURRENT_LEASES" > "$STATE_FILE"

# Check if there are any active leases
if [ "$CURRENT_LEASES" -gt 0 ]; then
    # Check if this is a new connection
    if [ "$CURRENT_LEASES" -gt "$PREVIOUS_LEASES" ] || ! systemctl is-active --quiet flask-app.service; then
        echo "DHCP client detected, starting Flask service"
        systemctl start flask-app.service
        systemctl start next-js.service
    fi
else
    # No active leases, stop Flask service
    echo "No DHCP clients, stopping Flask service"
    systemctl stop flask-app.service
    systemctl stop next-js.service
fi